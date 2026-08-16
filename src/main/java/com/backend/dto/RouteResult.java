package com.backend.dto;
import java.util.List;
public record RouteResult(
    String vehicleId,
    List<String> route,
    double estimatedDistanceKm,
    int estimatedTimeMinutes
) {}
