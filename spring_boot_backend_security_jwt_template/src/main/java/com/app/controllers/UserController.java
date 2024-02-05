package com.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping("/availableRides")
	
	public void getAvailableRides() {
		
	}
	
	@GetMapping("/getBookings")
	public void getBookings() {
		
	}
	
	@PostMapping("/bookRide/{uId}")
	public void bookARide(@PathVariable int uId) {
		
	}
	
	
}
