package com.vst.support.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.vst.support.dto.SupportDto;
import com.vst.support.model.Support;
@Component
public class SupportConverter {
	public Support dtoToEntity(SupportDto supportDto) {
		Support feedback=new Support();
		BeanUtils.copyProperties(supportDto, feedback);
		return feedback;
		
		
		}
		public SupportDto entityToDto(Support support) {
			SupportDto supportDto=new SupportDto();
			BeanUtils.copyProperties(support,supportDto);
			return supportDto;
		}

}
