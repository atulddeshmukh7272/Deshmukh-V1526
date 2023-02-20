package com.vst.reward.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.vst.reward.dto.RewardDto;
import com.vst.reward.model.Reward;

@Component
public class RewardConverter {
	public Reward dtoToEntity(RewardDto rewardDto) {
		Reward reward=new Reward();
		BeanUtils.copyProperties(rewardDto, reward);
		return reward;
		
		
		}
		public RewardDto entityToDto(Reward reward) {
			RewardDto rewardDto=new RewardDto();
			BeanUtils.copyProperties(reward,rewardDto);
			return rewardDto;
		}

}
