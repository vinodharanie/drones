package com.musalasoft.drones.service;

import com.musalasoft.drones.dto.DroneDto;
import com.musalasoft.drones.enums.States;
import com.musalasoft.drones.exception.DronesAPIException;
import com.musalasoft.drones.model.Drone;
import com.musalasoft.drones.model.Medication;
import com.musalasoft.drones.model.Model;
import com.musalasoft.drones.repository.DroneRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DronesImplService implements DronesService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private ModelService modelService;

    @Autowired
    private MedicationService medicationService;

    @Override
    public void createDrone(DroneDto droneDto) {
        validateDroneInput(droneDto);
        Drone drone = convertToDrone(droneDto);
        try {
            droneRepository.saveAndFlush(drone);
        } catch (Exception e) {
            throw new DronesAPIException("Error occurred while creating drone");
        }
    }

    @Override
    public DroneDto getDrone(long droneId) {
        try {
            Drone drone = droneRepository.getReferenceById(droneId);
            return convertToDroneDto(drone);
        } catch (Exception e) {
            throw new DronesAPIException("Error occurred while fetching drone");
        }
    }

    @Override
    public void loadMedications(long droneId, List<Long> medicationIds) {
        Drone drone = droneRepository.getReferenceById(droneId);
        List<Medication> medications = medicationService.getAllMedications(medicationIds);
        validateMedicationWeightLimit(medications, drone.getWeightLimit());
        try {
            drone.setMedications(medications);
            droneRepository.saveAndFlush(drone);
        } catch (Exception e) {
            throw new DronesAPIException("Error occurred while fetching drone");
        }
    }

    private void validateMedicationWeightLimit(List<Medication> medications, BigDecimal weightLimit) {
        BigDecimal sumWeight = BigDecimal.ZERO;
        for (Medication medication : medications) {
            sumWeight = sumWeight.add(medication.getWeight());
        }
        if (weightLimit.compareTo(sumWeight) < 0) {
            throw new DronesAPIException("Drone's weight limit is " + weightLimit + "gr");
        }
    }

    private Model getModel(int modelId) {
        Model model = modelService.getModel(modelId);
        if (model == null) {
            throw new DronesAPIException("Provide a valid model id");
        }
        return model;
    }

    private void validateDroneInput(DroneDto droneDto) {

        if (StringUtils.isEmpty(droneDto.getSerialNumber()) || droneDto.getSerialNumber().length() == 100) {
            throw new DronesAPIException("Serial number length should be less than 101");
        }

        if (BigDecimal.ZERO.compareTo(droneDto.getWeightLimit()) >= 0 ||
                new BigDecimal("500").compareTo(droneDto.getWeightLimit()) < 0) {
            throw new DronesAPIException("Weight limit should be less than 501");
        }

        if (BigDecimal.ZERO.compareTo(droneDto.getBatteryCapacity()) > 0 ||
                new BigDecimal("100").compareTo(droneDto.getBatteryCapacity()) < 0) {
            throw new DronesAPIException("Battery capacity should be in percentage");
        }

        if (States.getState(droneDto.getState()) == null) {
            throw new DronesAPIException("Provide valid state");
        }
    }

    private Drone convertToDrone (DroneDto droneDto) {
        Model model = getModel(droneDto.getModelId());
        Drone drone = new Drone();
        BeanUtils.copyProperties(droneDto, drone);
        drone.setModel(model);
        return drone;
    }

    private DroneDto convertToDroneDto (Drone drone) {
        DroneDto droneDto = new DroneDto();
        BeanUtils.copyProperties(drone, droneDto);
        droneDto.setModelId(drone.getModel().getId());
        return droneDto;
    }
}
