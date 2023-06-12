package com.project.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.dtos.RoleDto;
import com.project.ecommerce.service.RoleService;

@RestController
@RequestMapping("api/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;

	@PostMapping("/createNewRole")
	public RoleDto createNewRole(@RequestBody @Valid RoleDto roleDto) {
		return this.roleService.createNewRole(roleDto);
	}
}
