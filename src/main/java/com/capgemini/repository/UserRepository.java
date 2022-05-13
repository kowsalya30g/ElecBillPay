package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

	public User save(User user);
	public User findUserByUserName(String userName);
	public User findUserByuserId(Long UserId);

}
