package com.musalasoft.drones.controller;

import com.musalasoft.drones.service.DronesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DroneController {

    @Autowired
    private DronesService dronesService;

}
