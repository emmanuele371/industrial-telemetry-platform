package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "telemetry_events") // this creates the table in PostgreSQL
public class TelemetryEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-incrementing primary key

    @Column(name = "device_id", nullable = false)
    private String deviceId;

    @Column(name = "temperature_c")
    private double temperatureC;

    @Column(name = "voltage_v")
    private double voltageV;

    @Column(name = "battery_percent")
    private int batteryPercent;

    @Column(name = "machine_state")
    private String machineState;

    @Column(name = "error_code")
    private String errorCode;

    @Column(name = "received_at")
    private LocalDateTime receivedAt; //automatically set when data arrives

    // --- Constructors ---
    public TelemetryEvent() {}

    // --- Getters and Setters ---
    public Long getId() { return id; }
    // no setter for ID since the database manages it

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public double getTemperatureC() { return temperatureC; }
    public void setTemperatureC(double temperatureC) { this.temperatureC = temperatureC; }

    public double getVoltageV() { return voltageV; }
    public void setVoltageV(double voltageV) { this.voltageV = voltageV; }

    public int getBatteryPercent() { return batteryPercent; }
    public void setBatteryPercent(int batteryPercent) { this.batteryPercent = batteryPercent; }

    public String getMachineState() { return machineState; }
    public void setMachineState(String machineState) { this.machineState = machineState; }

    public String getErrorCode() { return errorCode; }
    public void setErrorCode(String errorCode) { this.errorCode = errorCode; }

    public LocalDateTime getReceivedAt() { return receivedAt; }
    public void setReceivedAt(LocalDateTime receivedAt) { this.receivedAt = receivedAt; }
}