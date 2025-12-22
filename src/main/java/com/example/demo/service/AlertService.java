package com.example.demo.service;
import com.example.demo.repository.AlertRecordRepository;
import org.springframework.stereotype.Service;

@Service
public class AlertService {
    private final AlertRecordRepository repository;
    public AlertService(AlertRecordRepository repository) {
        this.repository = repository;
    }
}