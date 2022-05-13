package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.persistence.InheritanceType;

@Table(name="users")
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId")
	private long userId;

	@NotBlank(message="User name cannot be blank")
	@Column(name="userName")
	@Email
	private String userName;

	@NotBlank(message="Password cannot be blank")
	@Column(name="password")
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long userId,String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.userId=userId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "["+"\n"+"userId = " + userId + "," +"\n"+"userName = " + userName + "\n"+"]";
	}



}
