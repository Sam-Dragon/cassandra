package com.example.repositories;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.model.Employee;

public interface EmployeeRepository extends CassandraRepository<Employee, Integer> {

	@AllowFiltering
	List<Employee> findByEmpSalaryGreaterThan(Float salary);
}
