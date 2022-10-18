package com.musalasoft.drones.repository;

import com.musalasoft.drones.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {

    List<Drone> findAllByStateAndBatteryCapacityGreaterThanEqual(int stateId, BigDecimal batteryCapacity);
}
