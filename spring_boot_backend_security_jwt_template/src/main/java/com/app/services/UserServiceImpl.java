package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.PublishRideDTO;
import com.app.dtos.RegisterDTO;
import com.app.entities.Register;
import com.app.repositories.PublishRideRepository;
import com.app.repositories.RegisterRepository;
import com.app.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private PublishRideRepository pRepo;
	
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<PublishRideDTO> getAvailableRides() {
		List<PublishRideDTO> list = pRepo.findAll().stream().map(m -> mapper.map(m, PublishRideDTO.class)).collect(Collectors.toList());
		return list;
	}

}
