package com.demo.CarDatabase.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.CarDatabase.dto.Car;

@RepositoryRestResource(path = "vehicles")
public interface CarRepository extends CrudRepository<Car, Long> {
	
}
