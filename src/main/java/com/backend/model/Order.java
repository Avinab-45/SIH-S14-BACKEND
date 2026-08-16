package com.backend.model;
import lombok.*;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class Order {
    private Long id;
    private String village;
    private String product;
    private double quantity;
    private String urgency;
    private String perishability;
    private LocalDateTime deadline;
    private String status;
}
