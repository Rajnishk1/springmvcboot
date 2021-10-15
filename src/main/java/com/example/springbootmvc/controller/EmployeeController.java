package com.example.springbootmvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springbootmvc.entity.Company;
import com.example.springbootmvc.entity.Department;
import com.example.springbootmvc.entity.Employee;
import com.example.springbootmvc.service.IDepartmentService;
import com.example.springbootmvc.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService _empSrvc;
	
	@Autowired
	private IDepartmentService _departmentSrvc;
	
	@GetMapping("/employees")
	public String home(Model model) {
		model.addAttribute("employees", _empSrvc.getEmployees());
		return "employees";
	}
	
	@GetMapping("/employees/new")
	public String registerEmployee(Model model) {
		model.addAttribute("departments", _departmentSrvc.departments());
		return "register-employee";
	}
	
	@GetMapping("/employees/filter")
	public String getFilterEmployees(HttpServletRequest request, Model model) {
		return "employee-filter";
	}
	
	@PostMapping("/employees/filter")
	public String filterEmployees(HttpServletRequest request, Model model) {
		int minSalary = Integer.parseInt(request.getParameter("minSalary"));
		int maxSalary = Integer.parseInt(request.getParameter("maxSalary"));
		model.addAttribute("employees", _empSrvc.getEmployees(minSalary, maxSalary));
		return "employee-filter";
	}
	
	/**
	 * Register employee.
	 * @return
	 * @throws ParseException 
	 */
	@PostMapping("/employees")
	public String AddEmployee(HttpServletRequest request, Model model) throws ParseException {
		Employee emp = new Employee();
		Department dep = new Department();
		int departmentId = Integer.parseInt(request.getParameter("department"));
		dep.setId(departmentId);
		emp.setDepartment(dep);
		emp.setEmpCode(request.getParameter("employeeCode"));
		
		if(request.getParameter("employmentTerminationDate") != null && request.getParameter("employmentTerminationDate").length() > 0) {
			Date empTerminationDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("employmentTerminationDate"));
			emp.setEmploymentTerminationDate(empTerminationDate);
		}
		Date dateOfJoining = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateOfJoining"));
		emp.setJoiningDate(dateOfJoining);
		emp.setName(request.getParameter("employeeName"));
		emp.setPayroll(request.getParameter("payroll") == null ? false : Boolean.parseBoolean(request.getParameter("payroll")));
		emp.setAllowances(Integer.parseInt(request.getParameter("allowances")));
		emp.setBasicSalary(Integer.parseInt(request.getParameter("basicSalary")));
		emp.setDeductions(Integer.parseInt(request.getParameter("deductions")));
		System.out.println(emp);
		
		_empSrvc.addEmployee(emp);
		if(emp.getId() > 0) {
			model.addAttribute("employee", emp);
		}
		return emp.getId() > 0 ? "employee-registration-success" : "register-employee";
	}
}