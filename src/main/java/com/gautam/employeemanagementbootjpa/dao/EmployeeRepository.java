package com.gautam.employeemanagementbootjpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.gautam.employeemanagementbootjpa.entity.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
