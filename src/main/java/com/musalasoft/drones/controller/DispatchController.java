package com.musalasoft.drones.controller;

import com.musalasoft.drones.dto.DroneDto;
import com.musalasoft.drones.model.Medication;
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
public class DispatchController {

    @Autowired
    private DronesService dronesService;

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDrone(@RequestBody DroneDto droneDto) {
        dronesService.createDrone(droneDto);
    }

    @PutMapping(value = "/{droneId}/medications")
    @ResponseStatus(HttpStatus.OK)
    public void loadMedications(@PathVariable long droneId, @RequestBody List<Long> medicationIds) {
        dronesService.loadMedications(droneId, medicationIds);
    }

    @GetMapping(value = "/{droneId}/medications")
    public ResponseEntity<List<Medication>> getMedications(@PathVariable long droneId) {
        return new ResponseEntity<>(dronesService.getDroneMedication(droneId), HttpStatus.OK);
    }
}
