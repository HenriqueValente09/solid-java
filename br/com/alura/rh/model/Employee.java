package br.com.alura.rh.model;



import br.com.alura.rh.ValidacaoException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Employee {

	private String name;
	private String cpf;
	private Position position;
	private BigDecimal salary;
	private LocalDate lastReadjustmentDate;

	public Employee(String name, String cpf, Position position, BigDecimal salary) {
		this.name = name;
		this.cpf = cpf;
		this.position = position;
		this.salary = salary;
	}

	public void readjustSalary(BigDecimal increase) {
		BigDecimal readjustPercentage = increase.divide(salary, RoundingMode.HALF_UP);
		if (readjustPercentage.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("The readjust can't be higher than 40% of the salary!");
		}
		this.salary = this.salary.add(increase);
		this.lastReadjustmentDate = LocalDate.now();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public LocalDate getLastReadjustmentDate() {
		return lastReadjustmentDate;
	}

	public void setLastReadjustmentDate(LocalDate lastReadjustmentDate) {
		this.lastReadjustmentDate = lastReadjustmentDate;
	}
}
