package com.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drivers")
public class DriverController {

	@PostMapping("/addVehicle/{dId}")
	public void addVehicle(@PathVariable int dId) {

	}
		
	@PostMapping("/publishRide/{dId}")
	public void publishRide(@PathVariable int dId) {

	}
	
	@GetMapping("/rideRequests")
	public void getRideRequests() {
		
	}
	
	@PutMapping("/acceptRide")
	public void acceptRide() {
		
	}
	
	@PutMapping("/rejectRide")
	public void rejectRide() {
		
	}
	
}