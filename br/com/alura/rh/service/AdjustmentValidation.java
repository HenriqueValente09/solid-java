package br.com.alura.rh.service;

import br.com.alura.rh.model.Employee;

import java.math.BigDecimal;

public interface AdjustmentValidation {
    void validate(Employee employee, BigDecimal adjustment);
}
