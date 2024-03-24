package com.service;

import java.util.List;

import com.model.User;

public interface UserService {

	void addUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(int id);
	
	User getUser(int id);
	
	List<User> getAllUser();
	
}
