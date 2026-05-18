package com.example.demo.controller;

import com.example.demo.dto.TelemetryEventDto;
import com.example.demo.entity.TelemetryEvent;
import com.example.demo.repository.TelemetryEventRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TelemetryController {

    // We inject the database repository into the controller
    private final TelemetryEventRepository repository;

    public TelemetryController(TelemetryEventRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/telemetry")
    public ResponseEntity<?> receiveTelemetry(@RequestBody TelemetryEventDto dto) {
        
        // 1. Validation
        if (dto.getDevice_id() == null || dto.getDevice_id().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "device_id must not be empty"));
        }
        if (dto.getBattery_percent() < 0 || dto.getBattery_percent() > 100) {
            return ResponseEntity.badRequest().body(Map.of("error", "battery_percent out of range"));
        }

        // 2. Map the DTO (Data Transfer Object) to the Entity (Database Record)
        TelemetryEvent entity = new TelemetryEvent();
        entity.setDeviceId(dto.getDevice_id());
        entity.setTemperatureC(dto.getTemperature_c());
        entity.setVoltageV(dto.getVoltage_v());
        entity.setBatteryPercent(dto.getBattery_percent());
        entity.setMachineState(dto.getMachine_state());
        entity.setErrorCode(dto.getError_code());
        entity.setReceivedAt(LocalDateTime.now()); // Set the exact time we received it

        // 3. Save to PostgreSQL!
        TelemetryEvent savedEntity = repository.save(entity);

        System.out.println("LOG: Event saved to DB with ID: " + savedEntity.getId());

        // 4. Return success response
        return ResponseEntity.ok(Map.of(
            "status", "stored",
            "db_id", savedEntity.getId(),
            "device_id", savedEntity.getDeviceId()
        ));
    }
}