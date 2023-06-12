package com.project.ecommerce.exceptions;

import lombok.Getter;

@Getter
public class ECommerceBusinessException extends ECommerceException {

	private static final long serialVersionUID = -478376748646484516L;

	public ECommerceBusinessException(String message) {
		super(message);
	}

	public ECommerceBusinessException(String message, String errorCode) {
		super(message, errorCode);
	}
}
