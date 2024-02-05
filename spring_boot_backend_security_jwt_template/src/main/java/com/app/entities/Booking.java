package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Booking extends BaseEntity {
	
	private boolean status;
// 	We'll fetch it from rideId	
//	double price;
		
	private int noOfSeats;
	
	@OneToOne
//	One user can book one ride at a time
	@JoinColumn(name = "ride_id")
	private PublishRide rideId;
	
//	Logged in user
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Register userId;	
	
}
