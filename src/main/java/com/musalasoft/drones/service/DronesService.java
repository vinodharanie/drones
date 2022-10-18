package com.musalasoft.drones.service;

import com.musalasoft.drones.dto.DroneDto;
import org.springframework.stereotype.Service;

@Service
public interface DronesService {

    void createDrone(DroneDto droneDto);

}
