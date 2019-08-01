package com.learning.java.dao;

import java.util.List;

import com.learning.java.model.User;

public interface UserDao {

	public void addUser(User user);
	public void updateUser(User user);
	public User getUserById(int id);
	public List<User> listUsers();
	
}
