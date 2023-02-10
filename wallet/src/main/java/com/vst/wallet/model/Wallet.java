package com.vst.wallet.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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
@Document(collection = "wallet")
public class Wallet {

	@Transient
	public static final String SEQUENCE_NAME = "wallet"; // for generating the id

	@Id
	private String walletId;
	private String walletAmount;
	private String walletCurrency;
	private String walletStatus;
	private String walletType;
	private String walletPaymentType;
	private String[] walletHistory;
	private String createDate;
	private String modifiedDate;
	private String createdBy;
	private String modifiedBy;
	boolean isActive = true;

}
