package com.app.repositories;

import com.app.dtos.RideSearchDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.City;
import com.app.entities.PublishRide;

import java.util.List;

public interface PublishRideRepository extends JpaRepository<PublishRide, Long> {
	public List<PublishRide> findByStartCityAndEndCity(String startCity, String endCity);
}
