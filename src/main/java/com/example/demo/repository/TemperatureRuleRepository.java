package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {
    
    // Custom method to find active rules
    List<TemperatureRule> findByActiveTrue();

    // Custom query to find the specific rule for a product type on a given date
    @Query("SELECT r FROM TemperatureRule r WHERE r.productType = :productType " +
           "AND :date BETWEEN r.effectiveFrom AND r.effectiveTo")
    TemperatureRule findApplicableRule(@Param("productType") String productType, @Param("date") LocalDate date);
}