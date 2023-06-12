package com.project.ecommerce.service.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.dtos.RoleDto;
import com.project.ecommerce.entities.Role;
import com.project.ecommerce.mappers.RoleMapper;
import com.project.ecommerce.repositories.RoleRepository;
import com.project.ecommerce.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public RoleDto createNewRole(RoleDto roleDto) {
		Role role = this.roleMapper.toRoleEntity(roleDto);
		role = roleRepository.save(role);
		return roleMapper.toRoleDto(role);		
	}
	
	@Override
	public Role findRoleById(String role) {
		Optional<Role> entity = this.roleRepository.findById(role);
		if (!entity.isPresent()) {
				throw new EntityNotFoundException("Role is not founesent with id: " + role);
		}		
		return entity.get();
	}
}
