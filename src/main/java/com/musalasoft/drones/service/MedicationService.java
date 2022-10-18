package com.musalasoft.drones.service;

import com.musalasoft.drones.model.Medication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedicationService {

    List<Medication> getAllMedications(List<Long> medicationIds);
}
