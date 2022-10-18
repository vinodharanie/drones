package com.musalasoft.drones.service;

import com.musalasoft.drones.dto.DroneDto;
import com.musalasoft.drones.model.Medication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DronesService {

    void createDrone(DroneDto droneDto);

    List<Medication> getDroneMedication(long droneId);

    List<DroneDto> getDroneWithState();

    void loadMedications(long droneId, List<Long> medicationIds);
}
