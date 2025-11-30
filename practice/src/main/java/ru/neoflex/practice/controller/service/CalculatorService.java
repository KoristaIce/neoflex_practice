package ru.neoflex.practice.controller.service;

import ru.neoflex.practice.demo.model.CalculationRecord;
import ru.neoflex.practice.controller.repository.CalculationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CalculatorService {

    private final CalculationRepository repository;

    public CalculatorService(CalculationRepository repository) {
        this.repository = repository;
    }

    public double sum(double a, double b) {
        double result = a + b;
        CalculationRecord record = new CalculationRecord("SUM", a, b, result);
        repository.save(record);
        return result;
    }

    public double subtract(double a, double b) {
        double result = a - b;
        CalculationRecord record = new CalculationRecord("SUBTRACT", a, b, result);
        repository.save(record);
        return result;
    }

    public List<CalculationRecord> getAllHistory() {
        return repository.findAll();
    }
}