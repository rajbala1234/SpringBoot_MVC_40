package com.cg.EmployeeManagementSystem_Boot_MVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.EmployeeManagementSystem_Boot_MVC.entity.Employee;
import com.cg.EmployeeManagementSystem_Boot_MVC.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	//1.getAllListOfEmployee
	@GetMapping()
	public String listEmployees(Model model)
	{
		model.addAttribute("list", service.getAllEmployee());
		return "employees";
	}
	
	@GetMapping("/add")
	public String addEmployeeForm(Model model)
	{
		model.addAttribute("employee", new Employee());
		return "employee-form";
		
	}
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute ("employee") Employee emp)
	{
		service.saveEmployee(emp);
		return "redirect:/employees";
		
	}
	
	@GetMapping("/edit/{id}")
	public String getEditEmployeeForm(@PathVariable    long id,Model model)
	{
		model.addAttribute("employee", service.getEmployeeById(id));
		return "employee-form";
		
		
		
	}
	
	@PostMapping("/update/{id}")
	public String updateEmployee(@PathVariable   long id,@ModelAttribute   Employee emp)
	{
		service.updateEmployee(id, emp);
		return "redirect:/employees";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable   long id)
	{
		service.deleteEmployee(id);
		return "redirect:/employees";
		
	}
	
	
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
