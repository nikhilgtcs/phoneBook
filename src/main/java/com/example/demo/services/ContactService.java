package com.example.demo.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Contact;
import com.example.demo.entities.MobileNumbers;
import com.example.demo.repositories.ContactRepository;
import com.example.demo.repositories.MobileNumberRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private MobileNumberRepository mobileNumberRepository;
	
	public void addContact(Contact contact) {
		
		Set<MobileNumbers> temp = contact.getMobileNumbers();
		for(MobileNumbers m: temp) {
			m.setContact(contact);
		}
		contactRepository.save(contact);
		
	}

}
