package com.demo.CarDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.CarDatabase.dto.Car;
import com.demo.CarDatabase.repositories.CarRepository;

@RestController
public class CarController {
	
	private final CarRepository carRepository;
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
	@GetMapping("/cars")
	public Iterable<Car> getCars() {
		return this.carRepository.findAll(); 
		
	}

}
