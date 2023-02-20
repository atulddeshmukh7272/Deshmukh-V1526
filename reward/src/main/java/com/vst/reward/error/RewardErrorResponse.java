package com.vst.reward.error;

import java.time.LocalDateTime;

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
public class RewardErrorResponse {

	private String message;
	private HttpStatus status;
	private String statusCode;
	private LocalDateTime timeStamp;

}
