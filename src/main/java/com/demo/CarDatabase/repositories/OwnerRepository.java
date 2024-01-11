package com.demo.CarDatabase.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.CarDatabase.dto.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
