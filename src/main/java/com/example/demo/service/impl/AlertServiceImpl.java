package com.example.demo.service.impl;

import com.example.demo.entity.AlertRecord;
import com.example.demo.repository.AlertRecordRepository;
import com.example.demo.service.AlertService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {
    private final AlertRecordRepository repo;

    public AlertServiceImpl(AlertRecordRepository repo) { this.repo = repo; }

    @Override
    public AlertRecord triggerAlert(AlertRecord ar) { return repo.save(ar); }

    @Override
    public List<AlertRecord> getAlertsByShipment(Long id) { return repo.findByShipmentId(id); }
}