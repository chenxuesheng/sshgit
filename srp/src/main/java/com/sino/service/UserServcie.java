package com.sino.service;

import java.util.List;

import com.sino.model.User;

public interface UserServcie {
	
	void add(User user);
	
	void delete(String id);
	
	void update(User user);
	
	User getById(String id);
	
	List<User> findAll();

}
