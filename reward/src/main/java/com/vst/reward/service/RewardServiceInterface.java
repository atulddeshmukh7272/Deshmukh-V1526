package com.vst.reward.service;

import java.util.List;

import com.vst.reward.dto.RewardDto;
import com.vst.reward.model.Reward;

public interface RewardServiceInterface {

	public String add(RewardDto rewardDto);// save support

	public Reward show(String rewardId);// find support using id

	public List<Reward> showAll();

	public void edit(String rewardId, RewardDto rewardDto);// for update support

	public void remove(String supportId);// soft delete

}
