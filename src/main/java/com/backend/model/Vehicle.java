package com.backend.model;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class Vehicle {
    private Long id;
    private String vehicleId;
    private double capacity;
    private String type;
    private String currentLocation;
    private boolean available;
}
