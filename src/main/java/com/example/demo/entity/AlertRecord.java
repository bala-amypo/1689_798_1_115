package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AlertRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long breachId;
    private Long shipmentId;
    private Boolean acknowledged;
    private LocalDateTime sentAt;

    @PrePersist
    public void prePersist() {
        if (this.acknowledged == null) this.acknowledged = false;
        if (this.sentAt == null) this.sentAt = LocalDateTime.now();
    }

    // Getters/Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getBreachId() { return breachId; }
    public void setBreachId(Long id) { this.breachId = id; }
    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long id) { this.shipmentId = id; }
    public Boolean getAcknowledged() { return acknowledged; }
    public void setAcknowledged(Boolean val) { this.acknowledged = val; }
    public LocalDateTime getSentAt() { return sentAt; }
    public void setSentAt(LocalDateTime val) { this.sentAt = val; }
}