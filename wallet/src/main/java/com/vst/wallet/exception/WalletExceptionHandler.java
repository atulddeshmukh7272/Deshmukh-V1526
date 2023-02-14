package com.vst.wallet.exception;

import java.time.LocalDateTime;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class WalletExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(WalletException.class)
	public ResponseEntity<Object> handaleRecordNotFound(WalletException we) {
		WalletErrorMessage walletErrorMessage = new WalletErrorMessage();
		walletErrorMessage.setStatus(HttpStatus.NOT_FOUND);
		walletErrorMessage.setMessage(PAGE_NOT_FOUND_LOG_CATEGORY);
		walletErrorMessage.setTimeStamp(LocalDateTime.now());
		
		
		return new ResponseEntity<>(walletErrorMessage,walletErrorMessage.getStatus());
		
			
		
				
	}

}
