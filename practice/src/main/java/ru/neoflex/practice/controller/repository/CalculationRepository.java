package ru.neoflex.practice.controller.repository;

import ru.neoflex.practice.demo.model.CalculationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationRepository extends JpaRepository<CalculationRecord, Long> {
}