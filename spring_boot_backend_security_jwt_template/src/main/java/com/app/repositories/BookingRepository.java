package com.app.repositories;

import com.app.entities.Booking;
import com.app.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
