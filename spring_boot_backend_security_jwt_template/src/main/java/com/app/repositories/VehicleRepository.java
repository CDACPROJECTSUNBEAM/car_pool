package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import com.app.entities.Vehicle;

public interface VehicleRepository extends RevisionRepository<Vehicle, Long, Long> ,  JpaRepository<Vehicle, Long>  {

}
