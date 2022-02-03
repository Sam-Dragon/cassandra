package com.example.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.repositories.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@PostConstruct
	public void addDefaults() {
		repository.saveAll(List.of(new Employee(1, "Bangalore", "Ram", 984802233L, 50000.01F),
				new Employee(2, "Hydrabad", "Sam", 52545424L, 30500.99F),
				new Employee(3, "Jharkhand", "Jam", 774634636L, 90101.22F)));
	}

	@PostMapping
	public void createEmployee(@RequestBody Employee employee) {
		repository.save(employee);
	}

	@GetMapping
	public List<Employee> getEmployees() {
		return repository.findAll();
	}

	@GetMapping("/{salary}")
	public List<Employee> getEmployeesBySalary(@PathVariable Float salary) {
		return repository.findByEmpSalaryGreaterThan(salary);
	}
}
