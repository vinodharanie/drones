package com.musalasoft.drones.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@ToString
public class DroneDto {

    private Long id;

    private String serialNumber;

    private int modelId;

    private BigDecimal weightLimit;

    private BigDecimal batteryCapacity;

    private int state;

    Set<Long> medicationIds;
}
