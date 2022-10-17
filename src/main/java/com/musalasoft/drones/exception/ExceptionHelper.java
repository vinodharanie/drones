package com.musalasoft.drones.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHelper {

    @ExceptionHandler(value = { DronesAPIException.class })
    public ResponseEntity<Object> handleDronesAPIException(DronesAPIException ex) {
        Map<String, Object>  response = generateErrorResponse(ex, HttpStatus.BAD_REQUEST, "B001");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Map<String, Object> generateErrorResponse(Exception exception, HttpStatus httpStatus, String code) {
        Map<String, Object> responseParams = new HashMap<>();
        responseParams.put("message", exception.getMessage());
        responseParams.put("status", httpStatus.value());
        responseParams.put("code", code);
        return responseParams;
    }
}
