package com.example.demo.service;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.entity.ShipmentStatus;
import com.example.demo.repository.ShipmentRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShipmentRecordService {
    private final ShipmentRecordRepository repository;

    public ShipmentRecordService(ShipmentRecordRepository repository) {
        this.repository = repository;
    }

    public ShipmentRecord createShipment(ShipmentRecord shipment) {
        return repository.save(shipment);
    }

    public ShipmentRecord updateShipmentStatus(Long id, String status) {
        ShipmentRecord shipment = repository.findById(id).orElseThrow();
        try {
            shipment.setStatus(ShipmentStatus.valueOf(status.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid status: " + status);
        }
        return repository.save(shipment);
    }

    public ShipmentRecord getShipmentByCode(String code) {
        return repository.findByShipmentCode(code).orElse(null);
    }

    public ShipmentRecord getShipmentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<ShipmentRecord> getAllShipments() {
        return repository.findAll();
    }
}