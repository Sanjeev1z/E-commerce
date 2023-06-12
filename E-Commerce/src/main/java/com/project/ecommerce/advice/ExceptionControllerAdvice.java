package com.project.ecommerce.advice;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.project.ecommerce.dtos.ErrorResponse;
import com.project.ecommerce.exceptions.ECommerceBusinessException;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(ECommerceBusinessException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleBusinessException(ECommerceBusinessException ex) {
		return new ErrorResponse(ex);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorResponse handleAccessDeniedException(AccessDeniedException ex) {
		
		return new ErrorResponse(ex.getMessage(),"invalid.request");
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleBusinessException(EntityNotFoundException ex) {
		return new ErrorResponse(ex.getMessage(), "invalid.request");
	}
	
}
