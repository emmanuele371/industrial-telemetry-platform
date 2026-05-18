package com.example.demo.dto;

public class TelemetryEventDto {
    // We define the same event structure as in the C++ code, 
    // so that Spring Boot can automatically map the incoming JSON data to this DTO (Data Transfer Object)
    private String device_id;
    private double temperature_c;
    private double voltage_v;
    private int battery_percent;
    private String machine_state;
    private String error_code;

    // Getters and setters for all fields
    public String getDevice_id() { return device_id; }
    public void setDevice_id(String device_id) { this.device_id = device_id; }

    public double getTemperature_c() { return temperature_c; }
    public void setTemperature_c(double temperature_c) { this.temperature_c = temperature_c; }

    public double getVoltage_v() { return voltage_v; }
    public void setVoltage_v(double voltage_v) { this.voltage_v = voltage_v; }

    public int getBattery_percent() { return battery_percent; }
    public void setBattery_percent(int battery_percent) { this.battery_percent = battery_percent; }

    public String getMachine_state() { return machine_state; }
    public void setMachine_state(String machine_state) { this.machine_state = machine_state; }

    public String getError_code() { return error_code; }
    public void setError_code(String error_code) { this.error_code = error_code; }
}