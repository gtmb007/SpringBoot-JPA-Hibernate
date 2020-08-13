package com.gautam.employeemanagementbootjpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.gautam.employeemanagementbootjpa.entity.Department;


public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
