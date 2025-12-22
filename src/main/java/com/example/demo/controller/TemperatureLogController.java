package com.example.demo.controller;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
@Tag(name = "Temperature Logs", description = "Record and view sensor data")
public class TemperatureLogController {

    private final TemperatureLogService service;

    public TemperatureLogController(TemperatureLogService service) {
        this.service = service;
    }

    @PostMapping("/")
    @Operation(summary = "Record a new temperature log")
    public TemperatureSensorLog recordLog(@RequestBody TemperatureSensorLog log) {
        // Note: In a real app, this is where you'd trigger the BreachCheck!
        return service.recordLog(log); 
    }

    @GetMapping("/shipment/{shipmentId}")
    @Operation(summary = "Get logs for a specific shipment")
    public List<TemperatureSensorLog> getLogsByShipment(@PathVariable Long shipmentId) {
        return service.getLogsByShipment(shipmentId);
    }

    @GetMapping("/{id}")
    public TemperatureSensorLog getLogById(@PathVariable Long id) {
        return service.getLogById(id);
    }

    @GetMapping("/")
    public List<TemperatureSensorLog> getAllLogs() {
        return service.getAllLogs();
    }
}