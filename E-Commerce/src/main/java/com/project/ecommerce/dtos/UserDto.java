package com.project.ecommerce.dtos;

import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserDto {
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String phone;
	
	private String profile;
	
	private OffsetDateTime createdAt;

	private OffsetDateTime updatedAt;

}
