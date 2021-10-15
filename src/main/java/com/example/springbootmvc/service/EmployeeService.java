package com.example.springbootmvc.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootmvc.entity.Employee;
import com.example.springbootmvc.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	IEmployeeRepository _empRepo;
	
	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		System.out.println(emp);
		_empRepo.save(emp);
		System.out.println(emp);
		return emp;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = _empRepo.findAll();
		return employees;
	}

	@Override
	public List<Employee> getEmployees(int minSalary, int maxSalary) {
		List<Employee> employees = _empRepo.findEmployeeByBasicSalaryRange(minSalary, maxSalary);
		return employees;
	}

}
