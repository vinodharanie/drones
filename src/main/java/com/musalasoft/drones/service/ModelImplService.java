package com.musalasoft.drones.service;

import com.musalasoft.drones.model.Model;
import com.musalasoft.drones.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.musalasoft.drones.common.Constants.MODEL_CACHE;

@Service
public class ModelImplService implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Override
    @Cacheable(cacheNames = MODEL_CACHE, key = "{#modelId}")
    public Model getModel(int modelId) {
        return modelRepository.getReferenceById(modelId);
    }
}
