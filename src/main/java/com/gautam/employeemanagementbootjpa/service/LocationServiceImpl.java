package com.gautam.employeemanagementbootjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gautam.employeemanagementbootjpa.dao.LocationRepository;
import com.gautam.employeemanagementbootjpa.entity.Location;


@Service("locationService")
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository locationRepository;
	
	@Transactional
	@Override
	public Integer addLocation(Location loc) throws Exception {
		Location loc1=locationRepository.save(loc);
		if(loc1!=null) return loc.getLocId();
		else throw new Exception("Location Not Added!");
	}
	
	@Transactional
	public Integer updateLocation(Integer locId, Location loc) throws Exception {
		try {
			deleteLocation(locId);
			Location loc1=locationRepository.save(loc);
			return loc1.getLocId();
		} catch(Exception e) {
			throw new Exception("Location Not Updated!");
		}
	}

	@Transactional
	@Override
	public Integer deleteLocation(Integer locId) throws Exception {
		if(getLocation(locId).isPresent()) {
			locationRepository.deleteById(locId);
			return locId;
		} else throw new Exception("Location Not Deleted!");
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Location> getLocation(Integer locId) throws Exception {
		return locationRepository.findById(locId);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<List<Location>> getLocations() throws Exception {
		List<Location> locs=(List<Location>)locationRepository.findAll();
		if(locs==null || locs.isEmpty()) return Optional.empty();
		else return Optional.ofNullable(locs);
	}

}
