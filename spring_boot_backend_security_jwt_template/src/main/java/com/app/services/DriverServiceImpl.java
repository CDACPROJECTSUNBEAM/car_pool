package com.app.services;

import javax.transaction.Transactional;

import com.app.dtos.BookingDTO;
import com.app.entities.Booking;
import com.app.repositories.BookingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.PublishRideDTO;
import com.app.dtos.RegisterDTO;
import com.app.dtos.VehicleDTO;
import com.app.entities.PublishRide;
import com.app.entities.Register;
import com.app.entities.Vehicle;
import com.app.repositories.PublishRideRepository;
import com.app.repositories.RegisterRepository;
import com.app.repositories.VehicleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private RegisterRepository driverRepo;
	
	@Autowired
	private PublishRideRepository publishRepo;

	@Autowired
	private BookingRepository bRepo;


	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private RegisterRepository registerRepo;
	
	@Autowired
	private VehicleRepository vRepo;

	@Override
	public PublishRideDTO publishRide(Long id, PublishRideDTO pdto) {
		Register driver = driverRepo.findById(id).orElseThrow();
		if(driver != null) {
			PublishRide pRide = mapper.map(pdto, PublishRide.class);
			pRide.setDriverId(driver);
			publishRepo.save(pRide);
			return mapper.map(pRide, PublishRideDTO.class);
		}
		
		return null;
	}
	
	@Override
	public RegisterDTO getDriverDetails(Long id) {
		Register driverEntity = registerRepo.findById(id).orElseThrow();
		return mapper.map(driverEntity, RegisterDTO.class);
	}

	@Override
	public VehicleDTO addVehicle(Long id, VehicleDTO vDto) {
		Register driverEntity = registerRepo.findById(id).orElseThrow();
		Vehicle vehicleEntity = mapper.map(vDto, Vehicle.class);
		vehicleEntity.setDriverId(driverEntity);
		vRepo.save(vehicleEntity);
		return mapper.map(vehicleEntity, VehicleDTO.class);
	}

	@Override
	public VehicleDTO getVehicleByName(Long id, String car) {
		Register driverEntity = registerRepo.findById(id).orElseThrow();
		Vehicle vehicle = vRepo.getVehicle(driverEntity, car);
		return mapper.map(vehicle, VehicleDTO.class);
	}

	@Override
	public List<BookingDTO> getAllBookingsByDriverId(Long dId) {
		List<Booking> bookings = bRepo.findAll();
		List<Booking> bookingReq = new ArrayList<>();

		for(int i=0; i<bookings.size(); i++){
			Long driverId = bookings.get(i).getRideId().getDriverId().getId();
			if(Long.compare(driverId, dId) == 0){
				bookingReq.add(bookings.get(i));
			}
		}

		List<BookingDTO> list = bookingReq.stream().map(m -> mapper.map(m, BookingDTO.class)).collect(Collectors.toList());

		//fetch specific user details by userid in above list : Todo
		//fetch specific ride details by rideid in above list : Todo

		return list;
	}

}
