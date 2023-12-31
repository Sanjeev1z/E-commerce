package com.project.ecommerce.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class JwtRequest {
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;

}
