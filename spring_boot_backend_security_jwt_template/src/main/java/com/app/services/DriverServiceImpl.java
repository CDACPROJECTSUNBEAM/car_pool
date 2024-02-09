package com.app.services;

import javax.transaction.Transactional;

import com.app.dtos.*;
import com.app.entities.*;
import com.app.repositories.BookingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<BookingResponseDTO> getAllBookingsByDriverId(Long dId) {
//		List<Booking> bookings = bRepo.findAll();
//		List<Booking> bookingReq = new ArrayList<>();
//
//		for(int i=0; i<bookings.size(); i++){
//			Long driverId = bookings.get(i).getRideId().getDriverId().getId();
//			if(Long.compare(driverId, dId) == 0){
//				bookingReq.add(bookings.get(i));
//			}
//		}
//
//		List<BookingDTO> list = bookingReq.stream().map(m -> mapper.map(m, BookingDTO.class)).collect(Collectors.toList());
//
//		//fetch specific user details by userid in above list : Todo
//		List<Register> users = new ArrayList<>();
//		for(int i=0; i<bookingReq.size(); i++){
//			Register user = registerRepo.findById(bookingReq.get(i).getUserId().getId()).orElseThrow();
//			users.add(user);
//		}
//
//		List<RegisterDTO> userList = users.stream().map(m -> mapper.map(m, RegisterDTO.class)).collect(Collectors.toList());
//
//		//fetch specific ride details by rideid in above list : Todo
//		List<PublishRide> rides = new ArrayList<>();
//		for(int i=0; i<bookingReq.size(); i++){
//			PublishRide ride = publishRepo.findById(bookingReq.get(i).getRideId().getId()).orElseThrow();
//			rides.add(ride);
//		}
//
//		List<PublishRideDTO> rideList = rides.stream().map(m -> mapper.map(m, PublishRideDTO.class)).collect(Collectors.toList());
//
//		List<BookingResponseDTO> resList = new ArrayList<>();
//		for(int i=0; i<list.size(); i++){
//			BookingDTO bdto = list.get(i);
//
//			for(int j=0; j<userList.size(); j++){
//				if(bdto.getUserIdId().compareTo(userList.get(j).getId()) == 0){
//
//				}
//			}
//
//			for(int k=0; k<rideList.size(); k++){
//
//			}
//		}

		List<Booking> bookings = bRepo.findAll();
		List<BookingResponseDTO> bookingReq = new ArrayList<>();

		for(int i=0; i<bookings.size(); i++){
			Long driverId = bookings.get(i).getRideId().getDriverId().getId();
			if(Long.compare(driverId, dId) == 0){
				BookingResponseDTO brdto = new BookingResponseDTO();
				brdto.setNoOfSeats(bookings.get(i).getNoOfSeats());
				brdto.setPrice(bookings.get(i).getPrice());
			}
		}

		return null;
	}

	@Override
	public BookingDTO acceptRide(Long bId) {
		Booking booking = bRepo.findById(bId).orElseThrow();
		booking.setStatus(StatusType.ACCEPTED);
		return mapper.map(bRepo.save(booking), BookingDTO.class);
	}

	@Override
	public BookingDTO rejectRide(Long bId) {
		Booking booking = bRepo.findById(bId).orElseThrow();
		booking.setStatus(StatusType.REJECTED);
		return mapper.map(bRepo.save(booking), BookingDTO.class);
	}

}
