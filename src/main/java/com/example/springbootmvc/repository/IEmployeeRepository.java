package com.example.springbootmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springbootmvc.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("SELECT e from Employee e where e.basicSalary between :minSalary and :maxSalary")
	List<Employee> findEmployeeByBasicSalaryRange(int minSalary, int maxSalary);
}
