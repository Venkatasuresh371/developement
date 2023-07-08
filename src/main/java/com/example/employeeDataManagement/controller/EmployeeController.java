package com.example.employeeDataManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeDataManagement.entity.Employee;
import com.example.employeeDataManagement.request.EmployeeRequest;
import com.example.employeeDataManagement.response.EmployeeResponse;
import com.example.employeeDataManagement.response.Response;
import com.example.employeeDataManagement.service.EmployeeService;

@RestController
public class EmployeeController 
{
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/wish")
	public String WishMessage()
	{
		return "Welcome to SpringBoot";
	}
	
	@PostMapping("/addEmployee")
	public Response saveEmployee(@RequestBody EmployeeRequest employeeRequest)
	{
		return service.addEmployee(employeeRequest);
	}
	
	@PostMapping("/updateEmployee/{id}")
	public Response updateEmployee(@PathVariable Long id,@RequestBody Employee employee)
	{
		return service.updateEmployee(id, employee);
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Response getEmployeeById(@PathVariable Long id)
	{
		return service.getEmployeeById(id);
	}
	
	@GetMapping("/getEmployeeByName/{name}")
	public Response getEmployeeByName(@PathVariable String name)
	{
		return service.getEmployeeByName(name);
	}
	
	@GetMapping("/getAllEmployee")
	public EmployeeResponse getAllEmployee()
	{
		return service.getAllEmployee();
	}
	
	@DeleteMapping("/deleteEmployeeById/{id}")
	public Response deleteEmployeeById(@PathVariable Long id)
	{
		return service.deleteEmployeeById(id);
	}
}