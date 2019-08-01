package com.learning.java.service;

import java.util.List;

import com.learning.java.model.User;

public interface UserService {
	
	public void addUser(User user);
	public List<User> listUsers();
	public void updateUser(User user);
	public User getUserById(int id);

}
