package com.musalasoft.drones.controller;

import com.musalasoft.drones.dto.DroneDto;
import com.musalasoft.drones.service.DronesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/drones")
public class DroneController {

    @Autowired
    private DronesService dronesService;

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDrone(@RequestBody DroneDto droneDto) {
        dronesService.createDrone(droneDto);
    }

    @PutMapping(value = "/{droneId}")
    @ResponseStatus(HttpStatus.OK)
    public void loadMedications(@PathVariable long droneId, @RequestBody List<Long> medicationIds) {
        dronesService.loadMedications(droneId, medicationIds);
    }
}
