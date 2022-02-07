package com.example.demo.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.entities.Contact;
import com.example.demo.entities.MobileNumbers;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.services.MobileNumbersService;

@Controller
public class MobileNumbersController {
	
	@Autowired
	private MobileNumbersService mobileNumbersService;

	@PostMapping("/{id}/add-number")
	@Transactional
	public ResponseEntity<String> addNumber(@PathVariable("id") Integer id, @RequestBody MobileNumbers mobileNumber) {
		mobileNumbersService.addNumber(id, mobileNumber);
		return new ResponseEntity<String>("Mobile number added successfully", HttpStatus.OK);
		
	}
}
