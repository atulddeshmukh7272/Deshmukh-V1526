package com.vst.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.feedback.dto.FeedbackDto;

import com.vst.feedback.model.Feedback;
import com.vst.feedback.service.FeedbackServiceImpl;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/vst1")
public class FeedbackController {
	@Autowired
	FeedbackServiceImpl feedbackServiceImpl;

	// for save feedback
	@PostMapping("/feedback")
	public ResponseEntity<String> addFeedback(@Valid @RequestBody FeedbackDto feedbackDto) {

		feedbackServiceImpl.add(feedbackDto);
		return new ResponseEntity<>("Your Feedback added", HttpStatus.OK);

	}

	// for get feedback information
	@GetMapping("/feedback")
	public ResponseEntity<Feedback> getFeedback(@RequestParam("feedbackId") String feedbackId) {

		return ResponseEntity.ok(feedbackServiceImpl.show(feedbackId));

	}

	@GetMapping("/feedbacks")
	public ResponseEntity<List<Feedback>> getAllFeedback() {
		return ResponseEntity.ok(feedbackServiceImpl.showAll());
	}

	// for updating the feedback
	@PutMapping("/feedback")
	public ResponseEntity<String> updateFeedback(@RequestParam("feedbackId") String feedbackId,
			@RequestBody FeedbackDto feedbackDto) {
		feedbackServiceImpl.edit(feedbackId, feedbackDto);
		return new ResponseEntity<>("Details Update Succesfully", HttpStatus.OK);

	}

	// for soft delete
	@DeleteMapping("/feedback")
	public ResponseEntity<String> deleteFeedback(@RequestParam("feedbackId") String feedbackId) {

		feedbackServiceImpl.remove(feedbackId);
		return new ResponseEntity<>("Feedback Deleted", HttpStatus.OK);

	}

	// for finding feedback using feedback CustomerId
	@GetMapping("/feedbackcustomerid")
	public ResponseEntity<Feedback> getByFeddbackCustomerId(
			@RequestParam("feedbackCustomerId") String feedbackCustomerId) {
		return ResponseEntity.ok(feedbackServiceImpl.showByFeedbackCustomerId(feedbackCustomerId));

	}

	// for finding feedback using feedback Station Id
	@GetMapping("/feedbackstationid")
	public ResponseEntity<Feedback> getByFeddbackStationId(
			@RequestParam("feedbackStationId") String feedbackStationId) {
		return ResponseEntity.ok(feedbackServiceImpl.showByFeedbackStationId(feedbackStationId));

	}

	// for finding feedback using feedback HostId
	@GetMapping("/feedbackhostid")
	public ResponseEntity<Feedback> getByFeddbackHostId(@RequestParam("feedbackHostId") String feedbackHostId) {
		return ResponseEntity.ok(feedbackServiceImpl.showByFeedbackHostId(feedbackHostId));

	}

	// for finding feedback using feedback VendorId
	@GetMapping("/feedbackvendorid")
	public ResponseEntity<Feedback> getByFeddbackVendorId(@RequestParam("feedbackVendorId") String feedbackVendorId) {
		return ResponseEntity.ok(feedbackServiceImpl.showByFeedbackVendorId(feedbackVendorId));

	}
}
