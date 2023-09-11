package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class adjustmentService {
    public void employeeSalaryAdjust(Employee employee, BigDecimal adjustment) {
        BigDecimal salary = employee.getSalary();
        BigDecimal adjustmentPercentage = adjustment.divide(employee.getSalary(), RoundingMode.HALF_UP);
        if (adjustmentPercentage.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("The adjustment can't be higher than 40% of the salary!");
        }

        LocalDate lastAdjustmentDate = employee.getLastAdjustmentDate();
        LocalDate currentDate = LocalDate.now();
        long monthsSinceLastAdjustment = ChronoUnit.MONTHS.between(lastAdjustmentDate, currentDate);
        if (monthsSinceLastAdjustment < 6) {
            throw new ValidacaoException("The interval between adjustments must be at least 6 months!");
        }

        BigDecimal newSalary = salary.add(adjustment);
        employee.updateSalary(newSalary);
    }
}
