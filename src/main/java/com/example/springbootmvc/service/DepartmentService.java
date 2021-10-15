package com.example.springbootmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootmvc.entity.Department;
import com.example.springbootmvc.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	IDepartmentRepository _departmentRepo;
	
	@Override
	public List<Department> departments() {
		return _departmentRepo.findAll();
	}
	
}
