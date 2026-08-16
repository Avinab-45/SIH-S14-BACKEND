package com.backend.dto;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public record OrderRequest(
    @NotBlank String village,
    @NotBlank String product,
    @Positive double quantity,
    @NotBlank String urgency,
    @NotBlank String perishability,
    @NotNull LocalDateTime deadline
) {}
