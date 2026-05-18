package com.example.demo.controller;

import com.example.demo.dto.TelemetryEventDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController // says to Spring Boot that this class will handle HTTP requests and return JSON responses
@RequestMapping("/api") // All endpoints in this class will start with /api
public class TelemetryController {

    @PostMapping("/telemetry") // Handles POST requests to the /api/telemetry endpoint
    public ResponseEntity<?> receiveTelemetry(@RequestBody TelemetryEventDto event) {
        
        if (event.getDevice_id() == null || event.getDevice_id().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "device_id must not be empty"));
        }
        
        if (event.getBattery_percent() < 0 || event.getBattery_percent() > 100) {
            return ResponseEntity.badRequest().body(Map.of("error", "battery_percent out of range"));
        }

        // if we reach this point, the event is valid and we can process it (e.g., save to database, trigger alerts, etc.)
        System.out.println("log: Received valid event from device: " + event.getDevice_id());

        // Respond to the client with an HTTP 200 (OK) and a confirmation JSON
        return ResponseEntity.ok(Map.of(
            "status", "accepted",
            "device_id", event.getDevice_id()
        ));
    }
}