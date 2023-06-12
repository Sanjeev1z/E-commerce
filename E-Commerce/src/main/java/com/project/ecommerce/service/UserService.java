package com.project.ecommerce.service;

import com.project.ecommerce.dtos.UserDto;
import com.project.ecommerce.entities.User;

public interface UserService {
	
	UserDto registerNewUser(UserDto userDto);
	
	User getUser(String username);
	
	User findUserByUsername(String username);
	 
	void initDummyUserAndRoleData();
	
	
}
