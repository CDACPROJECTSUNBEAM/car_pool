package com.app.services;

import java.util.List;

import com.app.dtos.PublishRideDTO;
import com.app.dtos.RegisterDTO;

public interface UserService {
	public List<PublishRideDTO> getAvailableRides();
}
