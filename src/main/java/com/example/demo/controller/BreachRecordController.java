package com.example.demo.controller;

import com.example.demo.entity.BreachRecord;
import com.example.demo.service.BreachDetectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/breaches")
@Tag(name = "Breach Records", description = "View and manage temperature breaches")
public class BreachRecordController {

    private final BreachDetectionService service;

    public BreachRecordController(BreachDetectionService service) {
        this.service = service;
    }

    @GetMapping("/shipment/{shipmentId}")
    @Operation(summary = "Get breaches for a specific shipment")
    public List<BreachRecord> getBreachesByShipment(@PathVariable Long shipmentId) {
        return service.getBreachesByShipment(shipmentId);
    }

    @GetMapping("/")
    public List<BreachRecord> getAllBreaches() {
        return service.getAllBreaches();
    }
    
    // You can add resolveBreach endpoint if your Service has it
    @PutMapping("/{id}/resolve")
    public void resolveBreach(@PathVariable Long id) {
         service.resolveBreach(id);
    }
}