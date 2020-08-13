package com.gautam.employeemanagementbootjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gautam.employeemanagementbootjpa.dao.DepartmentRepository;
import com.gautam.employeemanagementbootjpa.entity.Department;


@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Transactional
	@Override
	public Integer addDepartment(Department dept) throws Exception {
		Department dept1=departmentRepository.save(dept);
		if(dept1!=null) return dept1.getDeptId();
		else throw new Exception("Department Not Added!");
	}

	@Transactional
	@Override
	public Integer deleteDepartment(Integer deptId) throws Exception {
		if(getDepartment(deptId).isPresent()) {
			departmentRepository.deleteById(deptId);
			return deptId;
		} else throw new Exception("Department Not Deleted!");
	}
	
	@Transactional(readOnly=true)
	@Override
	public Optional<Department> getDepartment(Integer deptId) throws Exception {
		return departmentRepository.findById(deptId);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<List<Department>> getDepartments() throws Exception {
		List<Department> depts=(List<Department>)departmentRepository.findAll();
		if(depts==null || depts.isEmpty()) return Optional.empty();
		else return Optional.ofNullable(depts);
	}

}
