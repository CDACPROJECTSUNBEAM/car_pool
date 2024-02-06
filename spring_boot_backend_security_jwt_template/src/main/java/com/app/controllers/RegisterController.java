package com.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.RegisterDTO;
import com.app.dtos.SigninDTO;
import com.app.services.RegisterService;



@RestController
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private RegisterService rservice;
	
	
	@PostMapping("/signup")
	public ResponseEntity<RegisterDTO> signup(@RequestBody @Valid RegisterDTO registerdto) {
		System.out.println(registerdto);
		return new ResponseEntity<RegisterDTO>(rservice.signup(registerdto), HttpStatus.CREATED); 
	}
	
	@PostMapping("/signin")
	public ResponseEntity<RegisterDTO> signin(@RequestBody SigninDTO signinDto) {
		System.out.println(signinDto);
		return new ResponseEntity<RegisterDTO>(rservice.signin(signinDto), HttpStatus.FOUND); 
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<RegisterDTO>> getAllUsers() {
		return new ResponseEntity<List<RegisterDTO>>(rservice.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public void logout() {
		
	}
	
	@PutMapping("/updateProfile/{id}")
	public ResponseEntity<RegisterDTO> updateProfile(@PathVariable Long id, @RequestBody RegisterDTO rdto) {
		return new ResponseEntity<RegisterDTO>(rservice.updateProfile(id, rdto), HttpStatus.OK);
	}
	
	
}
