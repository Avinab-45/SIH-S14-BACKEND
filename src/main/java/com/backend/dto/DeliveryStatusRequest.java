package com.backend.dto;
import jakarta.validation.constraints.NotBlank;
public record DeliveryStatusRequest(@NotBlank String status) {}
