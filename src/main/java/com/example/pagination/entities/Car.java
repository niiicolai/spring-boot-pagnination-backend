package com.example.pagination.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.*;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Car {
    
    @Id
    private int id;

    private String brand;

    private String model;

    private String color;

    private int kilometers;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;

    public Car(String brand, String model, String color, int kilometers) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.kilometers = kilometers;
    }
}
