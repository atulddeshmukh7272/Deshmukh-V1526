package com.vst.feedback.error;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vst.feedback.exception.FeedbackNotFoundException;
import com.vst.feedback.exception.IdNotAcceptableException;

public class FeedbackApiError {

	String errorMessage = "error massage";

	@ExceptionHandler(FeedbackNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, Object> userNotFound(FeedbackNotFoundException ex) {
		Map<String, Object> errorMap = new HashMap<>();
		FeedbackErrorResponse response = new FeedbackErrorResponse();
		response.setMessage("details you have given is not present");
		response.setStatusCode("404");
		response.setTimeStamp(LocalDateTime.now());

		errorMap.put("error message", response);
		return errorMap;

	}

	@ExceptionHandler(IdNotAcceptableException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public Map<String, Object> idNotFound(IdNotAcceptableException ex) {

		Map<String, Object> errorMap = new HashMap<>();

		FeedbackErrorResponse response = new FeedbackErrorResponse();
		response.setMessage("given id is not correct or not available");
		response.setStatus(HttpStatus.NOT_ACCEPTABLE);
		response.setStatusCode("406");
		response.setTimeStamp(LocalDateTime.now());

		errorMap.put("error message", response);
		return errorMap;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}

}
