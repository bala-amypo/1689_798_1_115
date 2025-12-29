package com.example.demo.controller;
import com.example.demo.service.BreachDetectionService;
import org.springframework.web.bind.annotation.RestController;
@RestController public class BreachRecordController {
    private final BreachDetectionService service;
    public BreachRecordController(BreachDetectionService service) { this.service = service; }
}