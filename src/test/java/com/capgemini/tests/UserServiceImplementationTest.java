/*package com.capgemini.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.model.User;
import com.capgemini.repository.UserRepository;
import com.capgemini.services.UserServiceImplementation;

//@RunWith(SpringRunner.class)
//@SpringBootTest
class UserServiceImplementationTest {

	@Autowired
	private UserServiceImplementation service;

	@MockBean
	private UserRepository repo;

	User user;
	String ans;
	String userName;
	String password;
	Long userId;

	@BeforeEach
	void setUp()
	{
		userName="mutteni@gmail.com";
		password="mutteni12";
		userId=(long) 210;
		user = new User(userId,userName,password);
		ans = user.toString();
	}


	@Test
	public void registerUserTest()
	{
		when(repo.save(user)).thenReturn(user);
		assertEquals(ans,service.registerUser(user));		
	}


	@Test
	public void searchUserByUserNameTest()
	{
		when(repo.findUserByUserName(userName)).thenReturn(user);
		assertEquals(ans,service.searchUserByUserName(userName));
	}

	@Test
	public void searchUserByUserIdTest()
	{
		when(repo.findUserByuserId(userId)).thenReturn(user);
		assertEquals(ans,service.searchUserByUserId(userId));
	}

}

*/


















