package com.project.ecommerce.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.ecommerce.dtos.UserDto;
import com.project.ecommerce.entities.Role;
import com.project.ecommerce.entities.User;
import com.project.ecommerce.exceptions.ECommerceBusinessException;
import com.project.ecommerce.mappers.UserMapper;
import com.project.ecommerce.repositories.RoleRepository;
import com.project.ecommerce.repositories.UserRepository;
import com.project.ecommerce.service.RoleService;
import com.project.ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleService  roleService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;	
	
	@Override
	public UserDto registerNewUser(UserDto userDto) {
		Set<Role> role = new HashSet<>();
		
		User user = userMapper.toUserEntity(userDto);
		Optional<User> local = this.userRepository.findByUsername(user.getUsername());
		
		if(local.isPresent()) {
			throw new ECommerceBusinessException("This username isn't available. Please try another.","invalid.request");
		}	
		else {

			Role entity = this.roleService.findRoleById("User");
			role.add(entity);
			user.setRole(role);
			user.setPassword(getEncodedPassword(user.getPassword()));
			
			user = userRepository.save(user);
		}
		
		return userMapper.toUserDto(user);
		
	}
	
	
	
	@Override
	public User getUser(String username) {
		return findUserByUsername(username);
	}
	
	
	@Override
	public User findUserByUsername(String username) {
		
		Optional<User> user = this.userRepository.findByUsername(username);
		if(user.isEmpty()) {
			throw new EntityNotFoundException("User not found with username: " + username);
		}
		return user.get();
	}	
	
	

	@Override
	public void initDummyUserAndRoleData() {	
//		
//		Role role1 = new Role();
//		role1.setRoleName("Admin");
//		role1.setRoleDescription("Admin Rights");	
//		
//		
//		Role role2 = new Role();
//		role2.setRoleName("User");
//		role2.setRoleDescription("Default role for newly created record");
//	
//		
//		
//		User user1 = new User();
//		user1.setUsername("snjv22");
//		user1.setFirstName("Sanjeev");
//		user1.setLastName("Soni");
//		user1.setPassword(getEncodedPassword("123456"));
//		user1.setEmail("snjv@gmail.com");
//		user1.setPhone("7587345233");
//		user1.setProfile("4uy5456.png");
//		Set<Role> user1Role= new HashSet<>();
//		user1Role.add(role1);
//		user1.setRole(user1Role);
//
////		User user2 = new User();
////		user2.setUserName("goyal33");
////		user2.setUserFirstName("Shubham");
////		user2.setUserLastName("Goyal");
////		user2.setUserPassword(getEncodedPassword("654321"));
////		Set<Role> user2Role= new HashSet<>();
////		user2Role.add(role2);
////		user2.setRole(user2Role);
//		
//		this.userRepository.saveAll(Arrays.asList(user1));	
//		
	}
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}






}
