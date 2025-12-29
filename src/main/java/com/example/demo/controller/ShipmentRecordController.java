package com.example.demo.controller;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentRecordController {
    private final ShipmentRecordService service;

    public ShipmentRecordController(ShipmentRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ShipmentRecord> createShipment(@RequestBody ShipmentRecord shipment) {
        return ResponseEntity.ok(service.createShipment(shipment));
    }

    @GetMapping
    public ResponseEntity<List<ShipmentRecord>> getAllShipments() {
        return ResponseEntity.ok(service.getAllShipments());
    }

    @GetMapping("/{code}")
    public ResponseEntity<ShipmentRecord> getShipmentByCode(@PathVariable String code) {
        return service.getShipmentByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ShipmentRecord> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(service.updateShipmentStatus(id, status));
    }
}