package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

    // Driver Login API
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credentials) {
        return ResponseEntity.ok(Map.of(
                "token", "dummy-driver-jwt-token",
                "driverId", "DRV-101",
                "name", "John Doe",
                "assignedVehicleId", "VEH-01"
        ));
    }

    // Get Deliveries Assigned to Specific Driver
    @GetMapping("/{driverId}/deliveries")
    public ResponseEntity<List<Map<String, Object>>> getDriverDeliveries(@PathVariable String driverId) {
        return ResponseEntity.ok(List.of(
                Map.of(
                        "deliveryId", "DEL-1001",
                        "pickupPoint", "Community Hub A",
                        "dropoffPoint", "Remote Health Center",
                        "priority", "HIGH_PERISHABLE",
                        "status", "ASSIGNED"
                )
        ));
    }

    // Driver Update Delivery Status
    @PatchMapping("/deliveries/{deliveryId}/status")
    public ResponseEntity<Map<String, String>> updateDeliveryStatus(
            @PathVariable String deliveryId,
            @RequestBody Map<String, String> requestBody) {
        return ResponseEntity.ok(Map.of(
                "deliveryId", deliveryId,
                "status", requestBody.getOrDefault("status", "IN_TRANSIT"),
                "message", "Delivery status updated successfully"
        ));
    }
}