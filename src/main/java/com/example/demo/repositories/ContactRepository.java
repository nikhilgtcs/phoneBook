package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
