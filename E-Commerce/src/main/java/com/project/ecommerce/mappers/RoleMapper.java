package com.project.ecommerce.mappers;

import org.mapstruct.Mapper;

import com.project.ecommerce.dtos.RoleDto;
import com.project.ecommerce.entities.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
	
	RoleDto toRoleDto(Role role);
	
	Role toRoleEntity(RoleDto roleDto);
}
