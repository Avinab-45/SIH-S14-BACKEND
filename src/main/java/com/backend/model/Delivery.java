package com.backend.model;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class Delivery {
    private Long id;
    private Long orderId;
    private String vehicleId;
    private List<String> route;
    private String status;
    private String eta;
    private LocalDateTime deliveryTime;
}
