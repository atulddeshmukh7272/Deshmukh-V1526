package com.vst.wallet.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import jakarta.validation.constraints.NotNull;
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
public class WalletDTO {
	@Transient
	public static final String SEQUENCE_NAME = "wallet"; // for generating the id

	@Id
	private String walletId;
	@NotNull
	private String walletAmount;
	@NotNull
	private String walletCurrency;
	@NotNull
	private String walletStatus;
	@NotNull
	private String walletType;
	@NotNull
	private String walletPaymentType;
	@NotNull
	private String[] walletHistory;
	@NotNull
	private String createDate;
	@NotNull
	private String modifiedDate;
	@NotNull
	private String createdBy;
	@NotNull
	private String modifiedBy;
	boolean isActive = true;

}
