package com.capgemini.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.model.User;
import com.capgemini.services.UserServiceImplementation;

@RestController
public class UserController {

	@Autowired
	private UserServiceImplementation userService;

	@PostMapping("/registerUser")
	public ResponseEntity<String> registerUser(@Valid @RequestBody User user)
	{
		return new ResponseEntity<String>(userService.registerUser(user),HttpStatus.OK); 
	}

	@GetMapping("/changePassword/{userName}/{oldPassword}/{newPassword}")
	public ResponseEntity<String> changePassword(@Valid @PathVariable("userName") String UserName, @PathVariable("oldPassword") String oldPassword, @PathVariable("newPassword") String newPassword)
	{
		return new ResponseEntity<String>(userService.changePassword(UserName, oldPassword, newPassword),HttpStatus.OK);
	}

	@GetMapping("/forgetPassword/{userName}")
	public ResponseEntity<String> forgetPassword(@PathVariable("userName") String UserName)
	{

		return new ResponseEntity<String>(userService.forgotPassword(UserName),HttpStatus.OK);
	}

	@GetMapping("/searchUserByUserName/{userName}")
	public ResponseEntity<String> searchUserByUserName(@PathVariable("userName") String userName)
	{
		return new ResponseEntity<String>(userService.searchUserByUserName(userName),HttpStatus.OK);
	}

	@GetMapping("/searchUserByUserId/{userId}")
	public ResponseEntity<String> searchUserByUserId(@PathVariable("userId") Long userId)
	{
		return new ResponseEntity<String>(userService.searchUserByUserId(userId),HttpStatus.OK);
	}

	@GetMapping("/loginUser/{userName}/{password}")
	public ResponseEntity<String> loginUser(@PathVariable("userName") String UserName, @PathVariable("password") String password)
	{
		String status= userService.loginUser(UserName, password);
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}


}
