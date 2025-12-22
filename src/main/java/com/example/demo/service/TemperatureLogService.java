package com.example.demo.service;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.repository.TemperatureSensorLogRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TemperatureLogService {
    private final TemperatureSensorLogRepository repository;

    public TemperatureLogService(TemperatureSensorLogRepository repository) {
        this.repository = repository;
    }

    public TemperatureSensorLog recordLog(TemperatureSensorLog log) {
        return repository.save(log);
    }

    public List<TemperatureSensorLog> getLogsByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public TemperatureSensorLog getLogById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<TemperatureSensorLog> getAllLogs() {
        return repository.findAll();
    }
}