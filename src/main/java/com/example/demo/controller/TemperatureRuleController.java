package com.example.demo.controller;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Temperature Rules", description = "Manage product temperature limits")
public class TemperatureRuleController {

    private final TemperatureRuleService service;

    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }

    @PostMapping("/")
    @Operation(summary = "Create a new rule")
    public TemperatureRule createRule(@RequestBody TemperatureRule rule) {
        return service.createRule(rule);
    }

    @GetMapping("/active")
    @Operation(summary = "Get all currently active rules")
    public List<TemperatureRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/product/{productType}")
    @Operation(summary = "Find applicable rule for a product and date")
    public TemperatureRule getRuleForProduct(
            @PathVariable String productType,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        if (date == null) date = LocalDate.now();
        return service.getRuleForProduct(productType, date);
    }

    @GetMapping("/")
    public List<TemperatureRule> getAllRules() {
        return service.getAllRules();
    }
}