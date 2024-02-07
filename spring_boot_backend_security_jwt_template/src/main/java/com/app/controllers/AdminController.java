package com.app.controllers;

import com.app.dtos.VehicleDTO;
import com.app.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private VehicleService vService;

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDTO>> getAllVehicles(){
        return new ResponseEntity<List<VehicleDTO>>(vService.getAllVehicles(), HttpStatus.OK);
    }
}
