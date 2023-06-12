package com.project.ecommerce.service;

import com.project.ecommerce.dtos.RoleDto;
import com.project.ecommerce.entities.Role;

public interface RoleService {

	RoleDto createNewRole(RoleDto roleDto);
	
	Role findRoleById(String role);
}
