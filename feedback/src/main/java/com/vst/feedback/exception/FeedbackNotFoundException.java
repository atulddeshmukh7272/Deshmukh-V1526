package com.vst.feedback.exception;

public class FeedbackNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FeedbackNotFoundException(String message) {
		super(message);
	}

}
