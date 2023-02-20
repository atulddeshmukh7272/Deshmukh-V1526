package com.vst.support.exception;

public class SupportNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SupportNotFoundException(String message) {
		super(message);
	}
}
