package com.example.demo.controller;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shipments")
@Tag(name = "Shipments", description = "Manage cold-chain shipments")
public class ShipmentRecordController {

    private final ShipmentRecordService service;

    public ShipmentRecordController(ShipmentRecordService service) {
        this.service = service;
    }

    @PostMapping("/")
    @Operation(summary = "Create a new shipment")
    public ShipmentRecord createShipment(@RequestBody ShipmentRecord shipment) {
        return service.createShipment(shipment);
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Update shipment status")
    public ShipmentRecord updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateShipmentStatus(id, status);
    }

    @GetMapping("/code/{shipmentCode}")
    @Operation(summary = "Get shipment by unique code")
    public ShipmentRecord getByCode(@PathVariable String shipmentCode) {
        return service.getShipmentByCode(shipmentCode);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get shipment by ID")
    public ShipmentRecord getById(@PathVariable Long id) {
        return service.getShipmentById(id);
    }

    @GetMapping("/")
    @Operation(summary = "List all shipments")
    public List<ShipmentRecord> getAll() {
        return service.getAllShipments();
    }
}