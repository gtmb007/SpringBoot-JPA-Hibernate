package com.gautam.employeemanagementbootjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gautam.employeemanagementbootjpa.dao.EmployeeRepository;
import com.gautam.employeemanagementbootjpa.entity.Employee;


@Service("employeeService")
public class EmployeeManagementServiceImpl implements EmployeeManagementService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Transactional
	public Integer addEmployee(Employee emp) throws Exception {
		Employee emp1=employeeRepository.save(emp);
		if(emp1!=null) return emp.getEmpId();
		else throw new Exception("Employee Not Added!");
	}
	
	@Transactional
	public Integer deleteEmployee(Integer empId) throws Exception {
		if(getEmployee(empId).isPresent()) {
			employeeRepository.deleteById(empId);
			return empId;
		} else {
			throw new Exception("Employee Not Deleted!");
		}
	}
	
	@Transactional
	public Integer updateEmployee(Integer empId, Employee newEmp) throws Exception {
		try {
			deleteEmployee(empId);
			Employee emp1=employeeRepository.save(newEmp);
			return emp1.getEmpId();
		} catch(Exception e) {
			throw new Exception("Employee Not Updated!");
		}
	}
	
	@Transactional(readOnly=true)
	public Optional<Employee> getEmployee(Integer empId) throws Exception {
		return employeeRepository.findById(empId);
	}
	
	@Transactional(readOnly=true)
	public Optional<List<Employee>> getEmployees() throws Exception {
		List<Employee> emps=(List<Employee>)employeeRepository.findAll();
		if(emps==null || emps.isEmpty()) return Optional.empty();
		else return Optional.ofNullable(emps);
	}
	
}
