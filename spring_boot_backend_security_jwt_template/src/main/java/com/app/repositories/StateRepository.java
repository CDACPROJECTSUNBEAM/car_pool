package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.entities.State;

public interface StateRepository extends JpaRepository<State, Long> {
	

}
