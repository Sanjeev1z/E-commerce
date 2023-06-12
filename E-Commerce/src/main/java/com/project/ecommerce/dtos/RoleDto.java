package com.project.ecommerce.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RoleDto {

	@NotBlank
	private String roleName;
	
	@NotBlank
	private String roleDescription;
	
}
