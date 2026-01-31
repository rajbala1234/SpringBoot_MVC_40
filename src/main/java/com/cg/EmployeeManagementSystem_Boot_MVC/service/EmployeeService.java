package com.cg.EmployeeManagementSystem_Boot_MVC.service;

import java.util.List;

import com.cg.EmployeeManagementSystem_Boot_MVC.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployeeById(long id);
	
	public void saveEmployee(Employee emp);
	
	public Employee updateEmployee(long id,Employee emp);
	
	public void deleteEmployee(long id);
	

}
