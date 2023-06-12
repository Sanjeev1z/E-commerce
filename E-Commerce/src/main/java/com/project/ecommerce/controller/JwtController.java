package com.project.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.dtos.JwtRequest;
import com.project.ecommerce.dtos.JwtResponse;
import com.project.ecommerce.service.impl.JwtServiceImpl;

@RestController
@RequestMapping("api/jwt")
public class JwtController {
	
	@Autowired
	private JwtServiceImpl jwtService;
	
	@PostMapping("/authenticate")
	public JwtResponse createJwtToken(@RequestBody @Valid JwtRequest request) {
		return jwtService.createJwtToken(request);		
	}

}
