package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.sun.istack.NotNull;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@NotNull
	@Size(max = 25)
//	@Pattern(regexp = "^[a-zA-Z\s]+$")
	private String firstName;
	
	@NotBlank
	@NotNull
	@Size(max = 25)
//	@Pattern(regexp ="^[a-zA-Z\s]+$")
	private String lastName;
	
	@Range(min = 0)
	@NotNull
	private Integer age;
	
	@NotBlank
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]*$")
	@Size(max = 7)
	private String houseNumber;
	
	@NotBlank
	@NotNull
	@Size(max = 50)
	private String street;
	
	@NotBlank
	@NotNull
	@Size(max = 25)
//	@Pattern(regexp = "^[a-zA-Z\s]+$")
	private String city;
	
	@NotBlank
	@NotNull
	@Pattern(regexp = "[0-9 ]+")
	@Size(max = 7)
	private String pin;
	
	@OneToMany(targetEntity=MobileNumbers.class, 
			mappedBy = "contact", 
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY)
	private Set<MobileNumbers> mobileNumbers;
	
	public Contact() {
		
	}

	public Contact(Integer id, @NotBlank @Size(max = 25) @Pattern(regexp = "^[a-zA-Z ]+$") String firstName,
			@NotBlank @Size(max = 25) @Pattern(regexp = "^[a-zA-Z ]+$") String lastName, @Range(min = 0) Integer age,
			@NotBlank @Pattern(regexp = "[^A-Za-z0-9]+") @Size(max = 7) String houseNumber,
			@NotBlank @Size(max = 50) String street,
			@NotBlank @Size(max = 25) @Pattern(regexp = "^[a-zA-Z ]+$") String city,
			@NotBlank @Pattern(regexp = "[0-9 ]+") @Size(max = 7) String pin, Set<MobileNumbers> mobileNumbers) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.houseNumber = houseNumber;
		this.street = street;
		this.city = city;
		this.pin = pin;
		this.mobileNumbers = mobileNumbers;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Set<MobileNumbers> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(Set<MobileNumbers> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
