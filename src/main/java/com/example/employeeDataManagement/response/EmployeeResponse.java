package com.example.employeeDataManagement.response;

import java.util.List;

import com.example.employeeDataManagement.dto.EmployeeDto;

public class EmployeeResponse 
{
	private String statusCode;
	private String successMessage;
	private String errorMessage;
	private List<EmployeeDto> empDtoList;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public List<EmployeeDto> getEmpDtoList() {
		return empDtoList;
	}
	public void setEmpDtoList(List<EmployeeDto> empDtoList) {
		this.empDtoList = empDtoList;
	}
	
	
}
