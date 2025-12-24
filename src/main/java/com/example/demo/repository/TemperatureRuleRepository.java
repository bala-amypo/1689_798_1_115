package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {
    List<TemperatureRule> findByActiveTrue();

    // Required by Test 90
    @Query("SELECT r FROM TemperatureRule r WHERE r.productType = :pType AND :date BETWEEN r.effectiveFrom AND r.effectiveTo")
    Optional<TemperatureRule> findApplicableRule(@Param("pType") String pType, @Param("date") LocalDate date);
}