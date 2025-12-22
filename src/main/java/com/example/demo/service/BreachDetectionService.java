package com.example.demo.service;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BreachDetectionService {
    private final BreachRecordRepository repository;

    public BreachDetectionService(BreachRecordRepository repository) {
        this.repository = repository;
    }

    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public List<BreachRecord> getAllBreaches() {
        return repository.findAll();
    }

    public void resolveBreach(Long id) {
        BreachRecord breach = repository.findById(id).orElseThrow();
        breach.setResolved(true);
        repository.save(breach);
    }
}