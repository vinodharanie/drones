package com.musalasoft.drones.service;

import com.musalasoft.drones.model.Medication;
import com.musalasoft.drones.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.musalasoft.drones.common.Constants.MEDICATION_CACHE;

@Service
public class MedicationImplService implements MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    @Override
    @Cacheable(cacheNames = MEDICATION_CACHE, key = "{#medicationIds}")
    public List<Medication> getAllMedications(List<Long> medicationIds) {
        return medicationRepository.findAllById(medicationIds);
    }
}
