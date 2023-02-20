package com.vst.feedback.service;

import java.util.List;

import com.vst.feedback.dto.FeedbackDto;
import com.vst.feedback.model.Feedback;

public interface FeedbackServiceInterface {
	public String add(FeedbackDto feedbackDto);// save the feedback

	public Feedback show(String feedbackId);// find feedback using id

	public List<Feedback> showAll();// return All feedback

	public void edit(String feedbackId, FeedbackDto feedbackDto);// for update feedback

	public void remove(String feedback);// soft delete

	public Feedback showByFeedbackCustomerId(String feedbackCustomerId);

	public Feedback showByFeedbackStationId(String feedbackStationId);

	public Feedback showByFeedbackHostId(String feedbackHostId);

	public Feedback showByFeedbackVendorId(String feedbackVendorId);
}
