package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.RegisterDTO;
import com.app.entities.Register;
import com.app.repositories.RegisterRepository;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterRepository rdao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public RegisterDTO signup(RegisterDTO rdto) {
		Register register =  mapper.map(rdto, Register.class);
		rdao.save(register);
		return mapper.map(register, RegisterDTO.class);
	}

	@Override
	public List<RegisterDTO> getAllUsers() {
	
		List<RegisterDTO> list = rdao.findAll().stream().map(m -> mapper.map(m, RegisterDTO.class)).collect(Collectors.toList());
		
		return list;
	}
	
	
	
}
