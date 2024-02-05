package com.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
	
	@PostMapping("/signup")
	public void signup() {
		
	}
	
	@PostMapping("/signin")
	public void signin() {
		
	}
	
	@GetMapping("/logout")
	public void logout() {
		
	}
	
	@PutMapping("/updateProfile/{id}")
	public void updateProfile(@PathVariable int id) {
		
	}
	
	
}
