package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class TemperatureSensorLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double temperatureValue;
    private Long shipmentId;
    private String location;

    // Getters/Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getTemperatureValue() { return temperatureValue; }
    public void setTemperatureValue(Double val) { this.temperatureValue = val; }
    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long id) { this.shipmentId = id; }
    public String getLocation() { return location; }
    public void setLocation(String loc) { this.location = loc; }
}