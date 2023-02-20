package com.vst.feedback.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.vst.feedback.dto.FeedbackDto;
import com.vst.feedback.model.Feedback;
//This is dto converter class
@Component
public class FeedbackConverter {
	public Feedback dtoToEntity(FeedbackDto feedbackDto) {
	Feedback feedback=new Feedback();
	BeanUtils.copyProperties(feedbackDto, feedback);
	return feedback;
	
	
	}
	public FeedbackDto entityToDto(Feedback feedback) {
		FeedbackDto feedbackDto=new FeedbackDto();
		BeanUtils.copyProperties(feedback,feedbackDto);
		return feedbackDto;
	}
	}


