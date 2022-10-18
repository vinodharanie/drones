package com.musalasoft.drones.service;

import com.musalasoft.drones.dto.DroneDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DronesService {

    void createDrone(DroneDto droneDto);

    DroneDto getDrone(long droneId);

    void loadMedications(long droneId, List<Long> medicationIds);
}
