package com.example.demo.controller;
import com.example.demo.service.TemperatureLogService;
import org.springframework.web.bind.annotation.RestController;
@RestController public class TemperatureLogController {
    private final TemperatureLogService service;
    public TemperatureLogController(TemperatureLogService service) { this.service = service; }
}