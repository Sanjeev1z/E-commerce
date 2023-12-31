package com.project.ecommerce.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.project.ecommerce.constants.AppConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	
	@Value("${app.jwt.secret_key}")
	private String SECRET_KEY;
	
	
	public String getUserNameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	private <T> T getClaimFromToken(String token, Function<Claims,T> claimResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimResolver.apply(claims);
	}
	
	private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
	
	public boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUserNameFromToken(token);
		// check if username we are getting from token and user are same
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
	
	private boolean isTokenExpired(String token) {
		final Date expirationDate = getExpirationDateFromToken(token);
		return expirationDate.before(new Date());
	}

	private Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + AppConstants.TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512 , SECRET_KEY)
				.compact();
	}
}