package br.com.alura.rh.service;

import br.com.alura.rh.model.Employee;

import java.math.BigDecimal;
import java.util.List;

public class AdjustmentService {

    private List<AdjustmentValidation> validations;

    public AdjustmentService(List<AdjustmentValidation> validations) {
        this.validations = validations;
    }

    public void employeeSalaryAdjustment(Employee employee, BigDecimal adjustment) {
        this.validations.forEach(v -> v.validate(employee, adjustment));

        BigDecimal newSalary = employee.getSalary().add(adjustment);
        employee.updateSalary(newSalary);
    }
}
