package com.gautam.employeemanagementbootjpa.service;

import java.util.List;
import java.util.Optional;

import com.gautam.employeemanagementbootjpa.entity.Employee;


public interface EmployeeManagementService {
	
	public Integer addEmployee(Employee emp) throws Exception;
	public Integer updateEmployee(Integer empId, Employee newEmp) throws Exception;
	public Integer deleteEmployee(Integer empId) throws Exception;
	public Optional<Employee> getEmployee(Integer empId) throws Exception;
	public Optional<List<Employee>> getEmployees() throws Exception;
	
}