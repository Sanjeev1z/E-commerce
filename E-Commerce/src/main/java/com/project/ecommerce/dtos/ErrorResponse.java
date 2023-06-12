package com.project.ecommerce.dtos;

import com.project.ecommerce.exceptions.ECommerceBusinessException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	private String message;

	private String errorCode;
	
	public ErrorResponse(ECommerceBusinessException ex) {
		this.message = ex.getMessage();
		this.errorCode = ex.getErrorCode();
	}	
}