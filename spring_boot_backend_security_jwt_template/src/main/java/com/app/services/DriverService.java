package com.app.services;

import com.app.dtos.PublishRideDTO;
import com.app.dtos.RegisterDTO;
import com.app.dtos.VehicleDTO;

public interface DriverService {
	public PublishRideDTO publishRide(Long id, PublishRideDTO pdto);
	
	public RegisterDTO getDriverDetails(Long id);
	
	public VehicleDTO addVehicle(Long id, VehicleDTO vDto);
}
