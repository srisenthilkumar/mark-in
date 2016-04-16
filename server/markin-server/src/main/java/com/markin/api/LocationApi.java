package com.markin.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.markin.model.Location;
import com.markin.repository.LocationRepo;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("/locations")
public class LocationApi {

	@Autowired
	private LocationRepo locationRepo;

	@RequestMapping(method = RequestMethod.GET)
	public List<Location> getLocationByDevice() {
		return locationRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{deviceId}")
	public Location getLocationByDevice(@PathVariable String deviceId) {
		return locationRepo.findByDeviceId(deviceId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void saveLocation(@RequestBody Location location) {
		locationRepo.save(location);
	}

}
