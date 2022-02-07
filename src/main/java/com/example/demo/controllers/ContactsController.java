package com.example.demo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Contact;
import com.example.demo.services.ContactService;

@RestController
public class ContactsController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping("/add-contact")
	@Transactional
	public ResponseEntity<String> addContact(@RequestBody @Valid Contact contact) {
		contactService.addContact(contact);
		return new ResponseEntity<>("added successfully", HttpStatus.CREATED);
	}

}
