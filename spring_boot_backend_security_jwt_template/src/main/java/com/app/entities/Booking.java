package com.app.entities;

import javax.persistence.*;

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

	@Enumerated(EnumType.STRING)
	private StatusType status;

	@Column(nullable = false)
	private double price;

	@Column(nullable = false)
	private int noOfSeats;
	
	@OneToOne
//	One user can book one ride at a time
	@JoinColumn(name = "ride_id")
	// further we'll fetch all details of ride
	private PublishRide rideId;
	
//	Logged in user
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Register userId;	
	
}
