package com.example.springbootmvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String name;
	@Column
	private String empCode;
	
	// Using @Temporal to convert java date to db type date
	@Column
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	@Column
	@Temporal(TemporalType.DATE)
	private Date employmentTerminationDate;
	@Column
	private Boolean payroll;
	@Column
	private Integer basicSalary;
	@Column
	private Integer allowances;
	@Column
	private Integer deductions;
	
	public Integer getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Integer basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Integer getAllowances() {
		return allowances;
	}

	public void setAllowances(Integer allowances) {
		this.allowances = allowances;
	}

	public Integer getDeductions() {
		return deductions;
	}

	public void setDeductions(Integer deductions) {
		this.deductions = deductions;
	}

	@OneToOne
	private Department department;
	
	public Employee() { }
	
	public int getId() {
		return id;
	}
	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getEmploymentTerminationDate() {
		return employmentTerminationDate;
	}

	public void setEmploymentTerminationDate(Date employmentTerminationDate) {
		this.employmentTerminationDate = employmentTerminationDate;
	}

	public Boolean getPayroll() {
		return payroll;
	}

	public void setPayroll(Boolean payroll) {
		this.payroll = payroll;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String str = "";
		try {
			str = new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
