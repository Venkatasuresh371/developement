package com.example.employeeDataManagement.response;

import com.example.employeeDataManagement.entity.Employee;

public class Response 
{
	private String statusCode;
	private String successMessage;
	private String errorMessage;
	private Employee emp;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String successCode) {
		this.statusCode = successCode;
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
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
}
