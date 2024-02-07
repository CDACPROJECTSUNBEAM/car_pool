package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.PublishRideDTO;
import com.app.dtos.RegisterDTO;
import com.app.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService uService;

	@GetMapping("/availableRides")
	public ResponseEntity<List<PublishRideDTO>> getAvailableRides() {
		return new ResponseEntity<List<PublishRideDTO>>(uService.getAvailableRides(), HttpStatus.OK);
	}
	
	@GetMapping("/getBookings")
	public void getBookings() {
		
	}
	
	@PostMapping("/bookRide/{uId}")
	public void bookARide(@PathVariable int uId) {
		
	}

	
}
