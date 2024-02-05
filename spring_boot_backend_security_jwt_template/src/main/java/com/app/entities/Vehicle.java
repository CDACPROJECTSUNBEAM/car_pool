package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Vehicle extends BaseEntity{
	@Column(name = "car_company", length = 45 ,  nullable = false)
	private String companny;
	
	@Column(length = 45 ,  nullable = false)
	private String model;
	
	@Column(name = "rc_number", length = 10 ,  nullable = false)
	private String rcNumber;
	
	@Column(name = "date_of_registration")
	private LocalDate dor;
	
	@Column(nullable = false, unique = true)
	private String licence;
	
	@Column(name = "aadhar_number", nullable = false, unique = true)
	private String aadharNo;
	
	@JoinColumn(name = "driver_id")
	@ManyToOne
	private Register driverId;
	
}
