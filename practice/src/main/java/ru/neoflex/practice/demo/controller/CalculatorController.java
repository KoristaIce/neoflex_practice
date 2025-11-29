package ru.neoflex.practice.demo.controller;

import ru.neoflex.practice.demo.model.CalculationRecord;
import ru.neoflex.practice.demo.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public double add(@RequestParam double a, @RequestParam double b) {
        return service.sum(a, b);
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double a, @RequestParam double b) {
        return service.subtract(a, b);
    }

    @GetMapping("/history")
    public List<CalculationRecord> getHistory() {
        return service.getAllHistory();
    }
}