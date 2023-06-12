package com.project.ecommerce.dtos;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Authority implements GrantedAuthority{

	private String authority;
	
	@Override
	public String getAuthority() {
		return this.authority;
	}
	

}
