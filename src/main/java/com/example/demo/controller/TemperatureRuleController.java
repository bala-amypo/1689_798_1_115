package com.example.demo.controller;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.web.bind.annotation.RestController;
@RestController public class TemperatureRuleController {
    private final TemperatureRuleService service;
    public TemperatureRuleController(TemperatureRuleService service) { this.service = service; }
}