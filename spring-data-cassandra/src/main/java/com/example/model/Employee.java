package com.example.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("emp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@PrimaryKeyColumn(value = "emp_id", type = PrimaryKeyType.PARTITIONED)
	private Integer empId;

	@Column(value = "emp_city")
	private String empCity;

	@Column(value = "emp_name")
	private String empName;

	@Column(value = "emp_phone")
	private Long empPhone;

	@Column(value = "emp_sal")
	private Float empSalary;
}
