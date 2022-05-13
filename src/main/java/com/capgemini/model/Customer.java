package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="customers")
public class Customer extends User {

	@Column(name="customerId")
	private Long customerId;

	@Column(name="adharNumber")
	private Long adharNumber;

	@NotBlank(message="First name cannot be blank")
	@Size(min =2 , message="First name should have at least 2 characters")
	@Column(name="firstName")
	private String firstName;

	private String middleName;

	@NotBlank(message="Last name cannot be blank")
	@Size(min =2 , message="Last name should have at least 2 characters")
	@Column(name="lastName")
	private String lastName;

	@NotBlank(message="Mobile Number cannot be blank")
	@Size(min =10, max=10 , message="Mobile Number should be 10 digits")
	@Column(name="mobileNumber")
	private String mobileNumber;

	@NotBlank(message="Email cannot be blank")
	@Email
	@Column(name="email")
	private String email;

	@NotBlank(message="Gender cannot be blank")
	@Column(name="gender")
	private String gender;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long customerId, Long adharNumber, String firstName, String middleName, String lastName,
			String mobileNumber, String email, String gender,Long userId, String userName, String password) {
		super(userId,userName,password);
		this.customerId = customerId;
		this.adharNumber = adharNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.gender = gender;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getAdharNumber() {
		return adharNumber;
	}

	public void setAddharNumber(Long adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "["+"\n"+ "userId = " + getUserId()+"\n" + "userName = "
				+ getUserName()+ "\n" + "customerId = " + customerId + "\n" + "adharNumber = " + adharNumber + "\n" + "firstName = " + firstName
				+ "\n"+"middleName = " + middleName + "\n"+"lastName = " + lastName + "\n" + "mobileNumber = " + mobileNumber
				+"\n"+  "email = " + email + "\n"+"gender = " + gender + "\n"+ "]"; 
	}






}
