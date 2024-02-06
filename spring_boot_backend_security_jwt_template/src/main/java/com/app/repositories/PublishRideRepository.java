package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.City;
import com.app.entities.PublishRide;

public interface PublishRideRepository extends JpaRepository<PublishRide, Long> {
	
}
