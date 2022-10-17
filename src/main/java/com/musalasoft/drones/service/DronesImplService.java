package com.musalasoft.drones.service;

import com.musalasoft.drones.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DronesImplService implements DronesService {

    @Autowired
    private DroneRepository droneRepository;

}
