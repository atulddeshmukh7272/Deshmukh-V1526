
package com.vst.reward.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.reward.converter.RewardConverter;
import com.vst.reward.dto.RewardDto;
import com.vst.reward.exception.IdNotAcceptableException;
import com.vst.reward.exception.RewardException;
import com.vst.reward.exception.RewardNotFoundException;
import com.vst.reward.model.Reward;
import com.vst.reward.repository.RewardRepository;

@Service
public class RewardServiceImpl implements RewardServiceInterface {
	@Autowired
	RewardRepository rewardRepository;
	@Autowired
	RewardConverter rewardConverter;
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@Override
	@Transactional
	public String add(RewardDto rewardDto) {
		rewardDto.setRewardId(sequenceGeneratorService.idGenerator());
		rewardDto.setActive(true);
		Reward reward = rewardConverter.dtoToEntity(rewardDto);
		rewardRepository.save(reward);
		return "Reward save successfully";
	}

	@Override
	@Transactional
	public Reward show(String rewardId) {
		if (!rewardId.isBlank()) {
			Reward reward = rewardRepository.findByRewardIdAndIsActiveTrue(rewardId);
			if (reward != null) {
				return reward;
			} else {
				throw new RewardNotFoundException("Given Id Is Not Available");
			}
		} else {
			throw new IdNotAcceptableException("Please Enter Correct Id");
		}
	}

	@Override
	@Transactional
	public List<Reward> showAll() {

		List<Reward> list = rewardRepository.findAllByAndIsActiveTrue();
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new RewardNotFoundException("Data Is Not Available");
		}
	}

	@Override
	@Transactional
	public void edit(String rewardId, RewardDto rewardDto) {
		if (!rewardId.isBlank()) {
			Reward reward = rewardConverter.dtoToEntity(rewardDto);// dto concept
			Reward obj = rewardRepository.findByRewardIdAndIsActiveTrue(rewardId);
			if (obj != null) {
				if (reward.getRewardName() != null)
					if (!reward.getRewardName().isBlank())
						obj.setRewardName(reward.getRewardName());
				if (reward.getRewardPoints() != null)
					if (!reward.getRewardPoints().isBlank())
						obj.setRewardPoints(reward.getRewardPoints());
				if (reward.getRewardDescription() != null)
					if (!reward.getRewardDescription().isBlank())
						obj.setRewardDescription(reward.getRewardDescription());
				if (reward.getRewardCategory() != null)
					if (!reward.getRewardCategory().isBlank())
						obj.setRewardCategory(reward.getRewardName());
				if (reward.getRewardCategory() != null)
					if (!reward.getRewardCategory().isBlank())
						obj.setRewardCategory(reward.getRewardCategory());
				if (reward.getRewardImage() != null)
					if (!reward.getRewardImage().isBlank())
						obj.setRewardImage(reward.getRewardImage());
				if (reward.getRewardQuantity() != null)
					if (!reward.getRewardQuantity().isBlank())
						obj.setRewardQuantity(reward.getRewardQuantity());
				if (reward.getRewardRedeemDate() != null)
					if (!reward.getRewardRedeemDate().isBlank())
						obj.setRewardRedeemDate(reward.getRewardRedeemDate());
				if (reward.getRewardExpirationDate() != null)
					if (!reward.getRewardExpirationDate().isBlank())
						obj.setRewardExpirationDate(reward.getRewardExpirationDate());
				if (reward.getRewardStatus() != null)
					if (!reward.getRewardStatus().isBlank())
						obj.setRewardStatus(reward.getRewardStatus());
				if (reward.getModifiedDate() != null)
					if (!reward.getModifiedDate().isBlank())
						obj.setModifiedDate(reward.getModifiedDate());
				if (reward.getCreatedBy() != null)
					if (!reward.getCreatedBy().isBlank())
						obj.setCreatedBy(reward.getCreatedBy());
				if (reward.getModifiedBy() != null)
					if (!reward.getModifiedBy().isBlank())
						obj.setModifiedBy(reward.getModifiedBy());
				rewardRepository.save(obj);

			} else {
				throw new RewardNotFoundException("Given Id Is Not Present");
			}
		} else {
			throw new RewardException("Please Enter Correct Id");
		}
	}

	public void remove(String rewardId) {
		if (!rewardId.trim().isEmpty()) {
			Reward reward = rewardRepository.findByRewardIdAndIsActiveTrue(rewardId);// soft delet
			if (reward != null) {
				reward.setActive(false);
				rewardRepository.save(reward);
			} else {
				throw new RewardNotFoundException("Reward  Is Not Found");
			}
		} else {
			throw new IdNotAcceptableException("Given Wallet Id Is Not Found");
		}
	}
}