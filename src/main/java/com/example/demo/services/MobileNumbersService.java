package com.example.demo.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Contact;
import com.example.demo.entities.MobileNumbers;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.ContactRepository;
import com.example.demo.repositories.MobileNumberRepository;

@Service
public class MobileNumbersService {

	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private MobileNumberRepository mobileNumberRepository;

	public void addNumber(Integer id, MobileNumbers mobileNumber) {

		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contact with id: " + id + " does not exists"));
		Set<MobileNumbers> temp = contact.getMobileNumbers();
		mobileNumber.setContact(contact);
		temp.add(mobileNumber);
		contact.setMobileNumbers(temp);
		contactRepository.save(contact);

	}

}
