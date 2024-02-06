package com.app.services;

import java.util.List;

import com.app.dtos.RegisterDTO;

public interface RegisterService {
	public RegisterDTO signup(RegisterDTO rdto);
	
	public List<RegisterDTO> getAllUsers();
	
	
}
