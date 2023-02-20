package com.vst.feedback.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.feedback.converter.FeedbackConverter;
import com.vst.feedback.dto.FeedbackDto;
import com.vst.feedback.exception.FeedbackNotFoundException;
import com.vst.feedback.exception.IdNotAcceptableException;
import com.vst.feedback.model.Feedback;
import com.vst.feedback.repository.FeedbackRepository;


@Service
public class FeedbackServiceImpl implements FeedbackServiceInterface {
	@Autowired
	FeedbackRepository feedbackRepository;
	@Autowired
	FeedbackConverter feedbackConverter;
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	public static final Logger logger = LogManager.getLogger(FeedbackServiceImpl.class);

	// for adding feedback
	@Override
	@Transactional
	public String add(FeedbackDto feedbackDto) {
		feedbackDto.setFeedbackId(sequenceGeneratorService.idGenerator());
		feedbackDto.setActive(true);
		Feedback feedback = feedbackConverter.dtoToEntity(feedbackDto);

		feedbackRepository.save(feedback);
		return "feedback save succefully";

	}

	// for get feedback using feedbackId
	@Override
	@Transactional
	public Feedback show(String feedbackId) {
		if (!feedbackId.isBlank()) {
			Feedback feedback = feedbackRepository.findByFeedbackIdAndIsActiveTrue(feedbackId);
			if (feedback != null) {
				return feedback;
			} else {
				throw new FeedbackNotFoundException("Given Id Is Not Available");
			}
		} else {
			throw new IdNotAcceptableException("please Enter Correct ID");
		}

	}

	// for show all feedback to user
	@Override
	@Transactional
	public List<Feedback> showAll() {
		List<Feedback> list = feedbackRepository.findAllByIsActiveTrue();
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new FeedbackNotFoundException("Data is Not Available");
		}
	}

	// for updating the feedback
	@Override
	@Transactional
	public void edit(String feedbackId, FeedbackDto feedbackDto) {
		if (!feedbackId.isBlank()) {
			Feedback feedback = feedbackConverter.dtoToEntity(feedbackDto);// dto concept
			Feedback obj = feedbackRepository.findByFeedbackIdAndIsActiveTrue(feedbackId);
			if (obj != null) {
				if (feedback.getFeedbackCustomerId() != null)
					if (feedback.getFeedbackCustomerId().isBlank())
						obj.setFeedbackStationId(feedback.getFeedbackCustomerId());

				if (feedback.getFeedbackStationId() != null)
					if (feedback.getFeedbackStationId().isBlank())
						obj.setFeedbackStationId(feedback.getFeedbackStationId());

				if (feedback.getFeedbackHostId() != null)
					if (feedback.getFeedbackHostId().isBlank())
						obj.setFeedbackHostId(feedback.getFeedbackHostId());

				if (feedback.getFeedbackVendorId() != null)
					if (feedback.getFeedbackVendorId().isBlank())
						obj.setFeedbackVendorId(feedback.getFeedbackVendorId());

				if (feedback.getFeedbackText() != null)
					if (feedback.getFeedbackText().isBlank())
						obj.setFeedbackText(feedback.getFeedbackText());

				if (feedback.getFeedbackRating() != null)
					if (feedback.getFeedbackRating().isBlank())
						obj.setFeedbackRating(feedback.getFeedbackRating());

				if (feedback.getFeedbackDate() != null)
					if (feedback.getFeedbackDate().isBlank())
						obj.setFeedbackDate(feedback.getFeedbackDate());

				if (feedback.getFeedbackStatus() != null)
					if (feedback.getFeedbackStatus().isBlank())
						obj.setFeedbackStatus(feedback.getFeedbackStatus());

				if (feedback.getFeedbackReplies() != null)
					if (feedback.getFeedbackReplies().isBlank())
						obj.setFeedbackReplies(feedback.getFeedbackReplies());

				if (feedback.getFeedbackReplayDate() != null)
					if (feedback.getFeedbackReplayDate().isBlank())
						obj.setFeedbackReplayDate(feedback.getFeedbackReplayDate());

				if (feedback.getFeedbackReplayCustomerId() != null)
					if (feedback.getFeedbackReplayCustomerId().isBlank())
						obj.setFeedbackReplayCustomerId(feedback.getFeedbackReplayCustomerId());

				if (feedback.getFeedbackReplayStatus() != null)
					if (feedback.getFeedbackReplayStatus().isBlank())
						obj.setFeedbackReplayStatus(feedback.getFeedbackReplayStatus());

				if (feedback.getCreateDate() != null)
					if (feedback.getCreateDate().isBlank())
						obj.setCreateDate(feedback.getCreateDate());

				if (feedback.getModifiedDate() != null)
					if (feedback.getModifiedDate().isBlank())
						obj.setModifiedDate(feedback.getModifiedDate());

				if (feedback.getCreateBy() != null)
					if (feedback.getCreateBy().isBlank())
						obj.setCreateBy(feedback.getCreateBy());

				if (feedback.getModifiedBy() != null)
					if (feedback.getModifiedBy().isBlank())
						obj.setModifiedBy(feedback.getModifiedBy());
				feedbackRepository.save(obj);

			} else {
				throw new FeedbackNotFoundException("The Given Id is Not Present");
			}
		} else {
			throw new IdNotAcceptableException("Plsese Enter Correct Id");
		}

	}

	// for soft delete feedback using feedback id
	@Override
	@Transactional
	public void remove(String feedbackId) {
		if (!feedbackId.trim().isEmpty()) {
			Feedback feedback = feedbackRepository.findByFeedbackIdAndIsActiveTrue(feedbackId); // soft delete
			if (feedback != null) {
				feedback.setActive(false);
				feedbackRepository.save(feedback);
			} else {
				throw new FeedbackNotFoundException("Feedback is Not Found");
			}
		} else {
			throw new IdNotAcceptableException("Given Feedback Id Is Not Found");
		}
	}
//for finding the custom
	@Override
	public Feedback showByFeedbackCustomerId(String feedbackCustomerId) {
		if (!feedbackCustomerId.isBlank()) {

			Feedback feedback = feedbackRepository.findByFeedbackCustomerIdAndIsActiveTrue(feedbackCustomerId);
			if (feedback != null) {

				return feedback;
			} else {
				logger.info("Called FeedbackServiceImpl.showByFeedbackCustomerId");
				throw new FeedbackNotFoundException("Given CustomerId Is Not Available");
			}
		} else {
			logger.info("Called FeedbackServiceImpl.showByFeedbackCustomerId");
			throw new IdNotAcceptableException("Please Enter Correct CustomerId");
		}
	}
	
	@Override
	public Feedback showByFeedbackStationId(String feedbackStationId) {
		if (!feedbackStationId.isBlank()) {

			Feedback feedback = feedbackRepository.findByFeedbackHostIdAndIsActiveTrue(feedbackStationId);
			if (feedback != null) {

				return feedback;
			} else {
				logger.info("Called FeedbackServiceImpl.showByFeedbackStationId");
				throw new FeedbackNotFoundException("Given StationId Is Not Available");
			}
		} else {
			logger.info("Called FeedbackServiceImpl.showByFeedbackStationId");
			throw new IdNotAcceptableException("Please Enter Correct StationId");
		}
		
	}
	@Override
	public Feedback showByFeedbackHostId(String feedbackHostId) {
		
		if (!feedbackHostId.isBlank()) {

			Feedback feedback = feedbackRepository.findByFeedbackHostIdAndIsActiveTrue(feedbackHostId);
			if (feedback != null) {

				return feedback;
			} else {
				logger.info("Called FeedbackServiceImpl.showByFeedbackHostId");
				throw new FeedbackNotFoundException("Given HostId Is Not Available");
			}
		} else {
			logger.info("Called FeedbackServiceImpl.showByFeedbackHostId");
			throw new IdNotAcceptableException("Please Enter Correct HostId");
		}
	}

	@Override
	public Feedback showByFeedbackVendorId(String feedbackVendorId) {
		if (!feedbackVendorId.isBlank()) {

			Feedback feedback = feedbackRepository.findByFeedbackVendorIdAndIsActiveTrue(feedbackVendorId);
			if (feedback != null) {

				return feedback;
			} else {
				logger.info("Called FeedbackServiceImpl.showByFeedbackHostId");
				throw new FeedbackNotFoundException("Given VendorId Is Not Available");
			}
		} else {
			logger.info("Called FeedbackServiceImpl.showByFeedbackHostId");
			throw new IdNotAcceptableException("Please Enter Correct VendorId");
		}
	}

}
