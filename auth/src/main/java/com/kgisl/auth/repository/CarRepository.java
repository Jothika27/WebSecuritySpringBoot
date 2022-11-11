package com.kgisl.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.auth.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
	Car findByCarName(String carName);
	
}
