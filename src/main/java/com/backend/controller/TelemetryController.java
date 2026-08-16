package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/telemetry")
public class TelemetryController {

    // Real-time GPS Location Upload API
    @PostMapping("/gps")
    public ResponseEntity<Map<String, String>> uploadGps(@RequestBody Map<String, Object> gpsPayload) {
        return ResponseEntity.ok(Map.of(
                "status", "SUCCESS",
                "message", "GPS coordinates recorded"
        ));
    }

    // Offline Queue Bulk Synchronization API
    @PostMapping("/sync/offline")
    public ResponseEntity<Map<String, Object>> syncOfflineQueue(@RequestBody List<Map<String, Object>> offlineEvents) {
        return ResponseEntity.ok(Map.of(
                "status", "SUCCESS",
                "processedCount", offlineEvents.size(),
                "message", "Offline synchronization completed successfully"
        ));
    }
}