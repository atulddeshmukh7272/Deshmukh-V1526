package com.vst.reward.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reward")
public class Reward {
	@Id
	private String rewardId;
	private String rewardName;
	private String rewardPoints;
	private String rewardDescription;
	private String rewardCategory;
	private String rewardImage;
	private String rewardQuantity;
	private String rewardRedeemDate;
	private String rewardExpirationDate;
	private String rewardStatus;
	private String createdDate;
	private String modifiedDate;
	private String createdBy;
	private String modifiedBy;
	boolean isActive ;

}
