package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class BreachRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double breachValue;
    private Boolean resolved;
    private Long shipmentId;
    private Long logId;
    private String severity;

    @PrePersist
    public void prePersist() {
        if (this.resolved == null) this.resolved = false;
    }

    // Getters/Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getBreachValue() { return breachValue; }
    public void setBreachValue(Double val) { this.breachValue = val; }
    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean val) { this.resolved = val; }
    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long id) { this.shipmentId = id; }
    public Long getLogId() { return logId; }
    public void setLogId(Long id) { this.logId = id; }
    public String getSeverity() { return severity; }
    public void setSeverity(String val) { this.severity = val; }
}