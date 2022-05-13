package com.capgemini.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.exception.DuplicateUserException;
import com.capgemini.exception.InvalidLoginCredentialException;
import com.capgemini.exception.NoSuchUserException;
import com.capgemini.exception.PasswordLengthException;
import com.capgemini.exception.UserNameLengthException;
import com.capgemini.model.User;
import com.capgemini.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EmailSenderService emailService;

	@Override
	public String registerUser(User user) throws DuplicateUserException,UserNameLengthException,PasswordLengthException {
		// TODO Auto-generated method stub
		if(userRepo.findUserByUserName(user.getUserName())!=null)
			throw new DuplicateUserException("User already Exists with the given username. please use other username");
		if(user.getPassword().length()<8)
			throw new PasswordLengthException("Password should be atleast 8 characters");
		userRepo.save(user);
		return user.toString();
	}

	@Override
	public String loginUser(String userName, String password) throws InvalidLoginCredentialException {
		User user=userRepo.findUserByUserName(userName);
		if(user!=null && user.getPassword().equals(password))
			return "Login In Successfull";


		throw new InvalidLoginCredentialException("Invalid Credentials");
	}

	@Override
	public String changePassword(String userName, String oldPassword, String newPassword) throws NoSuchUserException,PasswordLengthException,InvalidLoginCredentialException {
		User user=userRepo.findUserByUserName(userName);
		if(user==null)
			throw new NoSuchUserException("No user exists with the provided username");
		if(!user.getPassword().equals(oldPassword))
			throw new InvalidLoginCredentialException("Invalid Credentials");
		if(newPassword.length()<8)
			throw new PasswordLengthException("Password should be atleast 8 characters");
		user.setPassword(newPassword);
		userRepo.save(user);
		return "Password changed Successfully";
	}

	@Override
	public String forgotPassword(String userName) throws NoSuchUserException{
		User user=userRepo.findUserByUserName(userName);
		if(user==null)
			throw new NoSuchUserException("No user exists with the provided username");
		emailService.sendSimpleEmail(userName, "Your Password for ElectricityBill Payment App is "+user.getPassword(),"Your Password for Electricity Bill Payment App");
		return "Password is sent to Your Mail";
	}

	@Override
	public String searchUserByUserName(String userName) throws NoSuchUserException {
		User user= userRepo.findUserByUserName(userName);
		if(user==null)
			throw new NoSuchUserException("No user exists with the provided username");
		return user.toString();
	}

	@Override
	public String searchUserByUserId(Long userId) throws NoSuchUserException {
		User user= userRepo.findUserByuserId(userId);
		if(user==null)
			throw new NoSuchUserException("No user exists with the provided userId");
		return user.toString();
	}

}
