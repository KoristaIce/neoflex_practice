package ru.neoflex.practice.controller.controller;

import ru.neoflex.practice.demo.model.CalculationRecord;
import ru.neoflex.practice.controller.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping("/plus/{a}/{b}")
    public Integer plus(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        return (int) service.sum(a, b);
    }

    @GetMapping("/minus/{a}/{b}")
    public Integer minus(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        return (int) service.subtract(a, b);
    }

    @GetMapping("/history")
    public List<CalculationRecord> getHistory() {
        return service.getAllHistory();
    }
}