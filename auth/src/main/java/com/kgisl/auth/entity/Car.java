package com.kgisl.auth.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
	
	@Id
	private int carId;
	private int price;
	private String carName;
	private String brand;
    private String owner;
	
	
	public Car() {
		super();
	}

	public Car(int carId, String carName, int price, String brand,String owner) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.price = price;
		this.brand = brand;
		this.owner= owner;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getprice() {
		return price;
	}

	public void setprice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
