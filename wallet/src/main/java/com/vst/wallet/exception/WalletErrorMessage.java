package com.vst.wallet.exception;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalletErrorMessage {
	
	private LocalDateTime timeStamp;
	private HttpStatus status;
	private String message;

}
