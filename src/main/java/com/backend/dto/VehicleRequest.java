package com.backend.dto;
import jakarta.validation.constraints.*;

public record VehicleRequest(
    @NotBlank String vehicleId,
    @Positive double capacity,
    @NotBlank String type,
    @NotBlank String currentLocation,
    boolean available
) {}
