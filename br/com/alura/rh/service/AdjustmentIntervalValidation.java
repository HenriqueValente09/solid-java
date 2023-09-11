package br.com.alura.rh.service;

import br.com.alura.rh.ValidationException;
import br.com.alura.rh.model.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AdjustmentIntervalValidation implements AdjustmentValidation {
    public void validate(Employee employee, BigDecimal adjustment) {
        BigDecimal salary = employee.getSalary();
        BigDecimal adjustmentPercentage = adjustment.divide(employee.getSalary(), RoundingMode.HALF_UP);
        if (adjustmentPercentage.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidationException("The adjustment can't be higher than 40% of the salary!");
        }

        BigDecimal newSalary = salary.add(adjustment);
        employee.updateSalary(newSalary);
    }
}
