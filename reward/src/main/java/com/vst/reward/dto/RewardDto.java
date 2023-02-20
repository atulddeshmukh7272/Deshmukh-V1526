package com.vst.reward.dto;



import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RewardDto {
	
	@Transient
	public static final String SEQUENCE_NAME = "reward"; //for generat
	@Id
	private String rewardId;
	@NotNull
	private String rewardName;
	@NotNull
	private String rewardPoints;
	@NotNull
	private String rewardDescription;
	@NotNull
	private String rewardCategory;
	@NotNull
	private String rewardImage;
	@NotNull
	private String rewardQuantity;
	@NotNull
	private String rewardRedeemDate;
	@NotNull
	private String rewardExpirationDate;
	@NotNull
	private String rewardStatus;
	@NotNull
	private String createdDate;
	@NotNull
	private String modifiedDate;
	@NotNull
	private String createdBy;
	@NotNull
	private String modifiedBy;
	@NotNull
	boolean isActive = true;

}
