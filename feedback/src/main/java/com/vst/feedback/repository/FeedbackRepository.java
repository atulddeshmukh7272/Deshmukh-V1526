package com.vst.feedback.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vst.feedback.model.Feedback;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {

	Feedback findByFeedbackIdAndIsActiveTrue(String feedbackId);

	List<Feedback> findAllByIsActiveTrue();

	Feedback findByFeedbackCustomerIdAndIsActiveTrue(String feedbackCustomerId);

	Feedback findByFeedbackStationIdAndIsActiveTrue(String feedbackStationId);

	Feedback findByFeedbackHostIdAndIsActiveTrue(String feedbackHostId);

	Feedback findByFeedbackVendorIdAndIsActiveTrue(String feedbackVendorId);
}
