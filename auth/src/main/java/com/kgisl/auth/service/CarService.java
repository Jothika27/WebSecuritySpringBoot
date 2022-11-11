package com.kgisl.auth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.auth.entity.Car;
import com.kgisl.auth.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}
	
	public Optional<Car> getCarById(int id) {
		return carRepository.findById(id);
	}
	
	public Car createCar(Car Car) {
		return carRepository.save(Car);
	}
	
	public Car updateCar(Car Car, int id) {
		return carRepository.save(Car);
	}
	
	public void deleteCar(int id) {
		carRepository.deleteById(id);
	}
}
