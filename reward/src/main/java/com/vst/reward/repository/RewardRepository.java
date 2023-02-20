package com.vst.reward.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vst.reward.model.Reward;

public interface RewardRepository extends MongoRepository<Reward, String> {

	public Reward findByRewardIdAndIsActiveTrue(String rewardId);

	public List<Reward> findAllByAndIsActiveTrue();// this is fetching all information from database

}
