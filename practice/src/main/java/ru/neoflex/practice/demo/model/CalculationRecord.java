package ru.neoflex.practice.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "calculation_records")
public class CalculationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String operation;
    private double num1;
    private double num2;
    private double result;
    private LocalDateTime createdAt;

    public CalculationRecord() {
    }

    public CalculationRecord(String operation, double num1, double num2, double result) {
        this.operation = operation;
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getOperation() {
        return operation;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public double getResult() {
        return result;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}