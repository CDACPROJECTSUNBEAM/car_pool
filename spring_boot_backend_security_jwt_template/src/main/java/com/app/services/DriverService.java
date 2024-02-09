package com.app.services;

import com.app.dtos.*;

import java.util.List;

public interface DriverService {
	public PublishRideDTO publishRide(Long id, PublishRideDTO pdto);
	
	public RegisterDTO getDriverDetails(Long id);
	
	public VehicleDTO addVehicle(Long id, VehicleDTO vDto);
	
	public VehicleDTO getVehicleByName(Long id, String car);

	public List<BookingResponseDTO> getAllBookingsByDriverId(Long dId);

	public BookingDTO acceptRide(Long bId);

	public BookingDTO rejectRide(Long bId);

}
