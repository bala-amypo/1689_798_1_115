package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TemperatureRule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double minTemp;
    private Double maxTemp;
    private Boolean active;
    private String productType;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    // Getters/Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getMinTemp() { return minTemp; }
    public void setMinTemp(Double val) { this.minTemp = val; }
    public Double getMaxTemp() { return maxTemp; }
    public void setMaxTemp(Double val) { this.maxTemp = val; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean val) { this.active = val; }
    public String getProductType() { return productType; }
    public void setProductType(String val) { this.productType = val; }
    public LocalDate getEffectiveFrom() { return effectiveFrom; }
    public void setEffectiveFrom(LocalDate val) { this.effectiveFrom = val; }
    public LocalDate getEffectiveTo() { return effectiveTo; }
    public void setEffectiveTo(LocalDate val) { this.effectiveTo = val; }
}