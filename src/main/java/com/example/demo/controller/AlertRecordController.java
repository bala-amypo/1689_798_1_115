package com.example.demo.controller;
import com.example.demo.service.AlertService;
import org.springframework.web.bind.annotation.RestController;
@RestController public class AlertRecordController {
    private final AlertService service;
    public AlertRecordController(AlertService service) { this.service = service; }
}