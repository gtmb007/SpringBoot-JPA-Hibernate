package com.gautam.employeemanagementbootjpa.service;

import java.util.List;
import java.util.Optional;

import com.gautam.employeemanagementbootjpa.entity.Department;


public interface DepartmentService {
	public Integer addDepartment(Department dept) throws Exception;
	public Integer deleteDepartment(Integer deptId) throws Exception;
	public Optional<Department> getDepartment(Integer deptId) throws Exception;
	public Optional<List<Department>> getDepartments() throws Exception;
}
