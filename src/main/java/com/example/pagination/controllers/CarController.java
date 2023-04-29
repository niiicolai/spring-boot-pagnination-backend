package com.example.pagination.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pagination.dto.CarResponse;
import com.example.pagination.services.CarPageableService;

@RestController
public class CarController {
    
    private CarPageableService carPageableService;

    public CarController(CarPageableService carPageableService) {
        this.carPageableService = carPageableService;
    }

    @GetMapping("/api/car")
    public List<CarResponse> findAll(@RequestParam int page, @RequestParam int size, @RequestParam List<String> sort) {
        return carPageableService.findAll(page, size, sort);
    }
}
