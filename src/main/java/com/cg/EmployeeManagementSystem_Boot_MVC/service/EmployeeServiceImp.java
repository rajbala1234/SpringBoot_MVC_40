package com.cg.EmployeeManagementSystem_Boot_MVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem_Boot_MVC.entity.Employee;
import com.cg.EmployeeManagementSystem_Boot_MVC.repo.EmployeeRepo;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	EmployeeRepo repo;

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public void saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		repo.save(emp);
	}

	@Override
	public Employee updateEmployee(long id, Employee emp) {
		// TODO Auto-generated method stub
		Employee emp1 = repo.findById(id).get();
		emp1.setName(emp.getName());
		emp1.setDepartment(emp.getDepartment());
		emp1.setMob_num(emp.getMob_num());
		emp1.setEmail(emp.getEmail());

		return repo.save(emp1);
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
       Employee emp =repo.findById(id).get();
       repo.delete(emp);
	}

}
