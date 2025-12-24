package com.example.demo.service;
import com.example.demo.entity.ShipmentRecord;
import java.util.List;
import java.util.Optional;

public interface ShipmentRecordService {
    ShipmentRecord createShipment(ShipmentRecord s);
    ShipmentRecord updateShipmentStatus(Long id, String status);
    Optional<ShipmentRecord> getShipmentByCode(String code);
    List<ShipmentRecord> getAllShipments();
}