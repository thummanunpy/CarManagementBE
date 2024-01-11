package com.demo.CarDatabase;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.CarDatabase.dto.Car;
import com.demo.CarDatabase.dto.Owner;
import com.demo.CarDatabase.dto.AppUser;
import com.demo.CarDatabase.repositories.AppUserRepository;
import com.demo.CarDatabase.repositories.CarRepository;
import com.demo.CarDatabase.repositories.OwnerRepository;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CarDatabaseApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(
			CarDatabaseApplication.class
	);
	
	private CarRepository carRepository;
	private OwnerRepository ownerRepository;
	private AppUserRepository appUserRepository;
	
	public CarDatabaseApplication(CarRepository carRepository, OwnerRepository ownerRepository, AppUserRepository appUserRepository) {
		this.carRepository = carRepository;
		this.ownerRepository = ownerRepository;
		this.appUserRepository = appUserRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CarDatabaseApplication.class, args);
		logger.info("Application Started");
	}

	@Override
	public void run(String... args) throws Exception {
		// Add owner objects and save these to db
	    Owner owner1 = new Owner("John" , "Johnson");
	    Owner owner2 = new Owner("Mary" , "Robinson");
	    ownerRepository.saveAll(Arrays.asList(owner1, owner2));
	    carRepository.save(new Car("Ford", "Mustang", "Red",
	                            "ADF-1121", 2023, 59000, owner1));
	    carRepository.save(new Car("Nissan", "Leaf", "White",
	                            "SSJ-3002", 2020, 29000, owner2));
	    carRepository.save(new Car("Toyota", "Prius", "Silver",
	                            "KKO-0212", 2022, 39000, owner2));
	    // Fetch all cars and log to console
	    for (Car car : carRepository.findAll()) 
	      {
	        logger.info("brand: {}, model: {}", car.getBrand(), 
	        car.getModel());
	      }
	    
	 // Username: user, password: user
	    appUserRepository.save(new AppUser("user","$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
        // Username: admin, password: admin
        appUserRepository.save(new AppUser("admin","$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
		
	}
	

}
