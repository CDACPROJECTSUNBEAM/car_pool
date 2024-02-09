package com.app.controllers;

import com.app.dtos.*;
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

import com.app.services.DriverService;

import java.util.List;

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
	
//	@GetMapping("/rideRequests/{dId}")
//	public ResponseEntity<?> getRideRequests(@PathVariable Long dId) {
//		List<BookingDTO> list = dService.getAllBookingsByDriverId(dId);
//
//		if(list.isEmpty()){
//			return new ResponseEntity<>("No Ride Requested...", HttpStatus.OK);
//		}
//
//		return new ResponseEntity<>(list, HttpStatus.OK);
//	}
	
	
	
	@PutMapping("/acceptRide/{bId}")
	public ResponseEntity<BookingDTO> acceptRide(@PathVariable Long bId) {
		return new ResponseEntity<>(dService.acceptRide(bId), HttpStatus.OK);
	}
	
	@PutMapping("/rejectRide/{bId}")
	public ResponseEntity<BookingDTO> rejectRide(@PathVariable Long bId) {
		return new ResponseEntity<>(dService.rejectRide(bId), HttpStatus.OK);
	}
	
}