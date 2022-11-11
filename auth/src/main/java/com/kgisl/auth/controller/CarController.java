package com.kgisl.auth.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.auth.entity.Car;
import com.kgisl.auth.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarService carService;
	
	@GetMapping("/")
	public List<Car> getAll() {
		return carService.getAllCars();
	}
	
	@GetMapping("/{id}")
	public Optional<Car> getById(int id) {
		return carService.getCarById(id);
	}
	
	@PostMapping("/")
	public Car create(Car car) {
		return carService.createCar(car);
	}
	
	@PutMapping("/{id}")
	public Car update(Car car, int id) {
		return carService.updateCar(car, id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(int id) {
		carService.deleteCar(id);
	}
}
