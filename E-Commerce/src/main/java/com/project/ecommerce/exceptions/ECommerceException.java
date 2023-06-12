package com.project.ecommerce.exceptions;

import lombok.Getter;

@Getter
public class ECommerceException extends RuntimeException {

	private static final long serialVersionUID = -478376748646484516L;

	protected String errorCode;

	public ECommerceException(String message) {
		super(message);
	}

	public ECommerceException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
}