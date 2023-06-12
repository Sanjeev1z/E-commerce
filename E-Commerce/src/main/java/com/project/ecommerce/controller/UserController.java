package com.project.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.dtos.UserDto;
import com.project.ecommerce.entities.User;
import com.project.ecommerce.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/registerNewUser")
	public UserDto registerNewUser(@RequestBody @Valid UserDto userDto) {
		return this.userService.registerNewUser(userDto);
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	  }	
	
//	@PostConstruct
//	public void initDummyUserAndRoleData() {
//		this.userService.initDummyUserAndRoleData();
//	}
	
//	@GetMapping("/forAdmin")
//	@PreAuthorize("hasRole('Admin')")
//	public String forAdmin() {
//		return "only for admin";
//	}
//	
//	@GetMapping("/forUser")
//	@PreAuthorize("hasRole('User')")
//	public String forUser() {
//		return "only for User";
//	}
//	
}
