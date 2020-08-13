package com.gautam.employeemanagementbootjpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.gautam.employeemanagementbootjpa.entity.Location;


public interface LocationRepository extends CrudRepository<Location, Integer> {

}
