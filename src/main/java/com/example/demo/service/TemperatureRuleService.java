package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TemperatureRuleService {
    private final TemperatureRuleRepository repository;

    public TemperatureRuleService(TemperatureRuleRepository repository) {
        this.repository = repository;
    }

    public TemperatureRule createRule(TemperatureRule rule) {
        if (rule.getMinTemp() >= rule.getMaxTemp()) {
            throw new IllegalArgumentException("Min temp must be less than Max temp");
        }
        return repository.save(rule);
    }

    public List<TemperatureRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    public TemperatureRule getRuleForProduct(String productType, LocalDate date) {
        return repository.findApplicableRule(productType, date);
    }

    public List<TemperatureRule> getAllRules() {
        return repository.findAll();
    }
}