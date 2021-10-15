package com.example.springbootmvc.service;

import java.util.List;

import com.example.springbootmvc.entity.Employee;

public interface IEmployeeService {
	Employee addEmployee(Employee emp);
	List<Employee> getEmployees();
	List<Employee> getEmployees(int minSalary, int maxSalary);
}
