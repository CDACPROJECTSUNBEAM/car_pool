package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.app.dtos.BookingDTO;
import com.app.entities.Booking;
import com.app.entities.PublishRide;
import com.app.entities.StatusType;
import com.app.repositories.BookingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.PublishRideDTO;
import com.app.dtos.RegisterDTO;
import com.app.entities.Register;
import com.app.repositories.PublishRideRepository;
import com.app.repositories.RegisterRepository;
import com.app.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private PublishRideRepository pRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private BookingRepository bRepo;

	@Autowired
	private RegisterRepository userRepo;
	
	@Override
	public List<PublishRideDTO> getAvailableRides() {
		List<PublishRideDTO> list = pRepo.findAll().stream().map(m -> mapper.map(m, PublishRideDTO.class)).collect(Collectors.toList());
		return list;
	}

	@Override
	public BookingDTO bookARide(Long uid, Long rid, BookingDTO bdto) throws Exception {
//		Persisted entity -- Respresent L1 cache .. any changes made in this entity sync with database
		Register user = userRepo.findById(uid).orElseThrow();
//		Persisted entity -- Respresent L1 cache .. any changes made in this entity sync with database
		PublishRide ride = pRepo.findById(rid).orElseThrow();

		Booking bookingEntity = mapper.map(bdto, Booking.class);

		if(bdto.getNoOfSeats() <= ride.getAvailableSeats()){
			bookingEntity.setUserId(user);
			bookingEntity.setRideId(ride);
			bookingEntity.setStatus(StatusType.PENDING);
			bookingEntity.setPrice(ride.getPrice()*bdto.getNoOfSeats());

			ride.setAvailableSeats(ride.getAvailableSeats() - bdto.getNoOfSeats());
//			After calling save
//			1.tx.Commit()
//			2.tx.Close()
			pRepo.save(ride);
		}else{
			throw new Exception("No. of seats should be less than available seats");
		}

		return mapper.map(bRepo.save(bookingEntity), BookingDTO.class);
	}

}
