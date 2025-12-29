package com.example.demo.controller;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.web.bind.annotation.RestController;
@RestController public class ShipmentRecordController {
    private final ShipmentRecordService service;
    public ShipmentRecordController(ShipmentRecordService service) { this.service = service; }
}