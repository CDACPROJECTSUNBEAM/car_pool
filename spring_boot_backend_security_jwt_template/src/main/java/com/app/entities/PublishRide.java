package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Audited
public class PublishRide extends BaseEntity {
	
	@Column(name = "start_city", nullable = false)
	private String startCity;
	
	@Column(name = "dest_city" , nullable = false)
	private String endCity;
	
	@Column(name = "date_of_journey" , nullable = false)
	private LocalDate doj;
	
	@Column(name = "end_of_journey" , nullable = false)
	private LocalDate eoj;
	
	@Column(name = "departure_time" , nullable = false)
	private LocalTime departureTime;
	
	@Column(name = "reaching_time" , nullable = false)
	private LocalTime reachingTime;
	
//	Further we'll find id of vehicle(details) by provided car name
	@Column(name = "car_name" , nullable = false)
	private String car;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private int availableSeats;
	
	
	
	
//	driverId ---> Driver who is publishing the ride 
//	Many to one 
//	Driver can publish multiple rides
//	Unidirectional Relationship
	
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Register driverId;




	public PublishRide(String startCity, String endCity, LocalDate doj, LocalDate eoj, LocalTime departureTime, LocalTime reachingTime,
			String car, double price, int availableSeats, Register driverId) {
		this.startCity = startCity;
		this.endCity = endCity;
		this.doj = doj;
		this.eoj = eoj;
		this.departureTime = departureTime;
		this.reachingTime = reachingTime;
		this.car = car;
		this.price = price;
		this.availableSeats = availableSeats;
		this.driverId = driverId;
	}
	
	
	
}
