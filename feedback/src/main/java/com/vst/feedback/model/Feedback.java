package com.vst.feedback.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "feedback")
public class Feedback {

	@Id
	private String feedbackId;
	private String feedbackCustomerId;
	private String feedbackStationId;
	private String feedbackHostId;
	private String feedbackVendorId;
	private String feedbackText;
	private String feedbackRating;
	private String feedbackDate;
	private String feedbackStatus;
	private String feedbackReplies;
	private String feedbackReplayDate;
	private String feedbackReplayCustomerId;
	private String feedbackReplayStatus;
	private String createDate;
	private String modifiedDate;
	private String createBy;
	private String modifiedBy;
	private boolean isActive;

}
