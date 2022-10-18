package com.musalasoft.drones.service;

import com.musalasoft.drones.model.Model;
import org.springframework.stereotype.Service;

@Service
public interface ModelService {

    Model getModel(int id);
}
