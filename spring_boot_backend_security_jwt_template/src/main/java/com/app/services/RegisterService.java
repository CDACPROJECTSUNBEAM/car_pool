package com.app.services;

import java.util.List;

import com.app.dtos.RegisterDTO;
import com.app.dtos.SigninDTO;

public interface RegisterService {
	public RegisterDTO signup(RegisterDTO rdto);
	
	public List<RegisterDTO> getAllUsers();
	
	public RegisterDTO signin(SigninDTO sdto);
	
	public RegisterDTO updateProfile(Long id, RegisterDTO rdto);
}
