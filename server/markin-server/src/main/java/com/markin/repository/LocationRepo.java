package com.markin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markin.model.Location;

public interface LocationRepo extends JpaRepository<Location, Long> {

	Location findByDeviceId(String deviceId);

}
