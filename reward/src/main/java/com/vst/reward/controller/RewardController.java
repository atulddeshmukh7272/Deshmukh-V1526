package com.vst.reward.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.reward.dto.RewardDto;

import com.vst.reward.model.Reward;
import com.vst.reward.service.RewardServiceImpl;

@RestController
@RequestMapping("vst1")
public class RewardController {
	@Autowired
	RewardServiceImpl rewardServiceImpl;

	@PostMapping("/reward")
	public ResponseEntity<String> addReward(@RequestBody RewardDto rewardDto) {

		rewardServiceImpl.add(rewardDto);

		return new ResponseEntity<>("Your reward added", HttpStatus.OK);
	}

	@GetMapping("/reward")
	public ResponseEntity<Reward> getRewardInfo(@RequestParam("rewardId") String rewardId) {

		rewardServiceImpl.show(rewardId);
		return ResponseEntity.ok(rewardServiceImpl.show(rewardId));
	}

	@GetMapping("/rewards")
	public ResponseEntity<List<Reward>> showAllReward() {
		return ResponseEntity.ok(rewardServiceImpl.showAll());

	}

	@PutMapping("/reward")
	public ResponseEntity<String> updateReward(@RequestParam("rewardId") String rewardId,
			@RequestBody RewardDto rewardDto) {
		rewardServiceImpl.edit(rewardId, rewardDto);
		return new ResponseEntity<>("details update Successfully", HttpStatus.OK);

	}

	@DeleteMapping("/reward")
	public ResponseEntity<String> deleteReward(@RequestParam("rewardId") String rewardId) {

		rewardServiceImpl.remove(rewardId);
		return new ResponseEntity<>("Data Deleted", HttpStatus.OK);

	}
}
