package com.backend.dto;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;
public record OptimizationRequest(
    @NotEmpty List<Long> orderIds,
    @NotEmpty List<Long> vehicleIds
) {}
