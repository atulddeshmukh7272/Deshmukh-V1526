package com.vst.support.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SupportErrorResponse {
	
	private String message;
	private HttpStatus status;
	private String statusCode;
	private LocalDateTime timeStamp;

}
