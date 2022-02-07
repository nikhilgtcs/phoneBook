package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.MobileNumbers;

@Repository
public interface MobileNumberRepository extends CrudRepository<MobileNumbers, Integer> {

}
