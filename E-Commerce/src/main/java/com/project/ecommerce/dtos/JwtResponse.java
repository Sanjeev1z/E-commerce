package com.project.ecommerce.dtos;

import com.project.ecommerce.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
	
	private User user;
	
	private String jwtToken;
}
