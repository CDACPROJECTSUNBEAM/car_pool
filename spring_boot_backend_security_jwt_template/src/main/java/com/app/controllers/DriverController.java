package com.app.controllers;

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

import com.app.dtos.ApiResponse;
import com.app.dtos.PublishRideDTO;
import com.app.dtos.RegisterDTO;
import com.app.dtos.VehicleDTO;
import com.app.services.DriverService;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
	
	@Autowired
	private DriverService dService;
	
	@PostMapping("/addVehicle/{dId}")
	public ResponseEntity<VehicleDTO> addVehicle(@PathVariable Long dId, @RequestBody VehicleDTO vdto) {
		return new ResponseEntity<VehicleDTO>(dService.addVehicle(dId, vdto), HttpStatus.CREATED);
	}
		
	@PostMapping("/publishRide/{dId}")
	public ResponseEntity<PublishRideDTO> publishRide(@PathVariable Long dId, @RequestBody PublishRideDTO pdto ) {
		
		return new ResponseEntity<PublishRideDTO>(dService.publishRide(dId, pdto), HttpStatus.CREATED);
	}
	
	@GetMapping("/driver/{dId}")
	public ResponseEntity<RegisterDTO> getDriverDetails(@PathVariable Long dId){
		return new ResponseEntity<RegisterDTO>(dService.getDriverDetails(dId), HttpStatus.OK);
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