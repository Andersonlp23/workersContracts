package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	// Associação com a classe Department
	private Department department;
	/*
	 * Associação com a classe HourContract Como o trabalhador tem vários contratos,
	 * é represetando através de Lista
	 */
	private List<HourContract> contracts = new ArrayList<>();

	public Worker() {

	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {

		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	// Metodo para adicionar um contrato associado ao trabalhador
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	// Metodo para remover um contrato associado ao trabalhador
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	// Metodo para responsável por calcular quanto o trabalhador ganhou baseado em
	// ano e mês
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();

		// Para cada contrato c na lista de contrato
		for (HourContract c : contracts) {

			// Pegando a data do contato e definindo como a data do calendário
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValue();

			}
		}

		return sum;
	}
}
