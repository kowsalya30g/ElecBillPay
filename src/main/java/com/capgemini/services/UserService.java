package com.capgemini.services;

import org.springframework.stereotype.Service;
import com.capgemini.exception.DuplicateUserException;
import com.capgemini.exception.InvalidLoginCredentialException;
import com.capgemini.exception.NoSuchUserException;
import com.capgemini.model.User;

@Service
public interface UserService {

	public String registerUser(User user) throws DuplicateUserException;
	public String loginUser(String userName, String password) throws InvalidLoginCredentialException;
	public String changePassword(String userName, String oldPassword, String newPassword);
	public String forgotPassword(String userName);
	public String searchUserByUserName(String userName)throws NoSuchUserException;
	public String searchUserByUserId(Long userId)throws NoSuchUserException;

}
