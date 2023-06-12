package com.project.ecommerce.service.impl;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.project.ecommerce.dtos.JwtRequest;
import com.project.ecommerce.dtos.JwtResponse;
import com.project.ecommerce.entities.User;
import com.project.ecommerce.exceptions.ECommerceBusinessException;
import com.project.ecommerce.service.UserService;
import com.project.ecommerce.util.JwtUtil;

@Service
public class JwtServiceImpl implements UserDetailsService{
		
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		User user = this.userService.findUserByUsername(username);		
		
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), getAuthorities(user));
		
	}
	
	private Set getAuthorities(User user) {
		Set authorities = user.getRole().stream()
			.map( role -> new SimpleGrantedAuthority("ROLE_"+role.getRoleName()))
			.collect(Collectors.toSet());
		
		return authorities;
	}
	
	public JwtResponse createJwtToken(JwtRequest jwtRequest) {
		String username = jwtRequest.getUsername();
		String userPassword = jwtRequest.getPassword();
		
		authenticate(username,userPassword);		
		
		final UserDetails userDetails = loadUserByUsername(username);
		
		String newGeneratedToken = jwtUtil.generateToken(userDetails);		
		User user = this.userService.findUserByUsername(username);
		
		return new JwtResponse(user,newGeneratedToken);
		
	}
	 
	private void authenticate(String username, String userPassword) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userPassword));
		}
		catch(DisabledException e) {
			throw new ECommerceBusinessException("User is disabled",e.getMessage());
		}
		catch (BadCredentialsException e) {
			throw new ECommerceBusinessException("Bad credentials from user");
		}
	}
	
//	private User findUserByUserName(String username) {
//		Optional<User> entity = this.userRepository.findByUsername(username);
//		if (!entity.isPresent()) {
//				throw new UsernameNotFoundException("User name is not valid: " + username);
//		}
//		
//		return entity.get();
//	}
}
