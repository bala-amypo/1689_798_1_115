package com.example.demo.service;

import com.example.demo.entity.AlertRecord;
import com.example.demo.repository.AlertRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlertService {
    private final AlertRecordRepository repository;

    public AlertService(AlertRecordRepository repository) {
        this.repository = repository;
    }

    public List<AlertRecord> getAlertsByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public List<AlertRecord> getAllAlerts() {
        return repository.findAll();
    }

    public AlertRecord acknowledgeAlert(Long id) {
        AlertRecord alert = repository.findById(id).orElseThrow();
        alert.setAcknowledged(true);
        return repository.save(alert);
    }
    
    public AlertRecord triggerAlert(AlertRecord alert) {
        return repository.save(alert);
    }
}