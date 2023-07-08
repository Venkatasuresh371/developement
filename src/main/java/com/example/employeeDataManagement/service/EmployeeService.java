package com.example.employeeDataManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.employeeDataManagement.dto.EmployeeDto;
import com.example.employeeDataManagement.entity.Employee;
import com.example.employeeDataManagement.repository.EmployeeRepository;
import com.example.employeeDataManagement.request.EmployeeRequest;
import com.example.employeeDataManagement.response.EmployeeResponse;
import com.example.employeeDataManagement.response.Response;

@Service
public class EmployeeService
{
	@Autowired
	private EmployeeRepository repository;

	public Response addEmployee(@RequestBody EmployeeRequest employeeRequest)
	{
		Response response = new Response();
		if(employeeRequest!=null)
		{
			Employee constructEmployee = constructEmployee(employeeRequest);
			repository.save(constructEmployee);
			response.setStatusCode("200");
			response.setSuccessMessage("Employee has been added successfull");
			response.setEmp(constructEmployee);
		}
		else
		{
			response.setStatusCode("400");
			response.setErrorMessage("employee has not been added");
		}
		return response;
	}

	private Employee constructEmployee(EmployeeRequest employeeRequest) 
	{
		Employee employee = new Employee();
		employee.setName(employeeRequest.getName());
		employee.setEmail(employeeRequest.getEmail());
		employee.setDesignation(employeeRequest.getDesignation());
		return employee;
	}

	public Response updateEmployee(@PathVariable Long id,@RequestBody Employee employee)
	{
		Response response = new Response();
		if(id!=null)
		{
			Employee getEmp = repository.findById(id).orElse(null);
			getEmp.setName(employee.getName());
			getEmp.setEmail(employee.getEmail());
			getEmp.setDesignation(employee.getDesignation());
			repository.save(getEmp);
			response.setStatusCode("210");
			response.setSuccessMessage("Employee has been updated");
			response.setEmp(employee);
		}
		else
		{
			response.setStatusCode("410");
			response.setErrorMessage("employee has not been updated");
		}
		return response;
	}

	public Response getEmployeeById(@PathVariable Long id)
	{
		Response response = new Response();
		if(id!=null)
		{
			Optional<Employee> getEmp = repository.findById(id);
			if(getEmp.isPresent())
			{
				Employee employee = new Employee();
				employee.setId(getEmp.get().getId());
				employee.setName(getEmp.get().getName());
				employee.setEmail(getEmp.get().getEmail());
				employee.setDesignation(getEmp.get().getDesignation());
				response.setEmp(employee);
				response.setStatusCode("220");
				response.setSuccessMessage("fetched successfully");
			}
			else
			{
				response.setStatusCode("420");
				response.setSuccessMessage("employee is not present");
			}
		}
		return response;
	}
	public Response getEmployeeByName(@PathVariable String name)
	{
		Response response = new Response();
		if(name!=null)
		{
			Optional<Employee> getEmp = repository.findByName(name);
			if(getEmp.isPresent())
			{
				Employee employee = new Employee();
				employee.setId(getEmp.get().getId());
				employee.setName(getEmp.get().getName());
				employee.setEmail(getEmp.get().getEmail());
				employee.setDesignation(getEmp.get().getDesignation());
				response.setEmp(employee);
				response.setStatusCode("230");
				response.setSuccessMessage("fetched successfully");
			}
			else
			{
				response.setStatusCode("430");
				response.setSuccessMessage("employee is not present");
			}
		}
		return response;
	}

	public EmployeeResponse getAllEmployee()
	{
		EmployeeResponse employeeResponse = new EmployeeResponse();
	    List<Employee> listOfEmployee = repository.findAll();
	    System.out.println("list of employee "+listOfEmployee.size());
	    System.out.println(listOfEmployee.get(0));
	    employeeResponse.setStatusCode("250");
	    employeeResponse.setSuccessMessage("fetched successfully");
	    employeeResponse.setEmpDtoList(constructEmployeeDto(listOfEmployee));
		return employeeResponse;
	}


	private List<EmployeeDto> constructEmployeeDto(List<Employee> listOfEmployee)
	{
		List<EmployeeDto> listOfEmpDtos = new ArrayList<>();
		for(Employee employees:listOfEmployee)
		{
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setId(employees.getId());
			employeeDto.setName(employees.getName());
			employeeDto.setDesignation(employees.getDesignation());
			listOfEmpDtos.add(employeeDto);
		}
		return listOfEmpDtos;
	}

	public Response deleteEmployeeById(@PathVariable Long id)
	{
		Response response = new Response();
		if(id!=null)
		{
			Optional<Employee> getEmp = repository.findById(id);
			if(getEmp.isPresent())
			{
				repository.deleteById(id);
				response.setStatusCode("240");
				response.setSuccessMessage("deleted successfully");
				response.setEmp(getEmp.get());
			}
			else
			{
				response.setStatusCode("440");
				response.setSuccessMessage("employee is not present");
			}
		}
		return response;
	}
}