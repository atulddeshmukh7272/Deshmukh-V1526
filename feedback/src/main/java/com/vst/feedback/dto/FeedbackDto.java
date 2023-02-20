package com.vst.feedback.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class  FeedbackDto {
	@Transient
	public static final String SEQUENCE_NAME = "feedback"; //for generating the id
		@Id
		private String feedbackId;
		@NotNull
		@NotBlank
		private String feedbackCustomerId;
		@NotNull
		@NotBlank
		private String feedbackStationId;
		@NotNull
		@NotBlank
		private String feedbackHostId;
		@NotNull
		@NotBlank
		private String feedbackVendorId;
		@NotNull
		@NotBlank
		private String feedbackText;
		@NotNull
		@NotBlank
		private String feedbackRating;
		@NotNull
		@NotBlank
		private String feedbackDate;
		@NotNull
		@NotBlank
		private String feedbackStatus;
		@NotNull
		@NotBlank
		private String feedbackReplies;
		@NotNull
		@NotBlank
		private String feedbackReplayDate;
		@NotNull
		@NotBlank
		private String feedbackReplayCustomerId;
		@NotNull
		@NotBlank
		private String feedbackReplayStatus;
		@NotNull
		@NotBlank
		private String createDate;
		@NotNull
		@NotBlank
		private String modifiedDate;
		@NotNull
		@NotBlank
		private String createBy;
		@NotNull
		@NotBlank
		private String modifiedBy;
	     boolean isActive=true;

	}



