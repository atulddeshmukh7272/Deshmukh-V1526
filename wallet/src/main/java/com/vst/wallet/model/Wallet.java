package com.vst.wallet.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "wallet")
public class Wallet {

	@Id
	private String walletId;
	private String walletAmount;
	private String walletCurrency;
	private String walletStatus;
	private String walletType;
	private String walletPaymentType;
	private String walletHistory;
	private String createDate;
	private String modifiedDate;
	private String createdBy;
	private String modifiedBy;
	boolean isActive;

}
