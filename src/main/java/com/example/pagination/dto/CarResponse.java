package com.example.pagination.dto;

import com.example.pagination.entities.Car;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarResponse {
    
    private int id;

    private String brand;

    private String model;

    private String color;

    private int kilometers;

    public CarResponse(Car car) {
        this.id = car.getId();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.color = car.getColor();
        this.kilometers = car.getKilometers();
    }
}
