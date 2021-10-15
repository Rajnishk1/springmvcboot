package com.example.springbootmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootmvc.entity.Department;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

}
