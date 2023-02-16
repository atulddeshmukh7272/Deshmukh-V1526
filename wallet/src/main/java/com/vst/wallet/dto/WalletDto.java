package com.vst.wallet.dto;

import java.util.List;

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
public class WalletDto {
	@Transient
	public static final String SEQUENCE_NAME = "wallet_sequnce"; // for generating the id

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

	private List<String> walletHistory;
	@NotNull
	private String createDate;
	@NotNull
	private String modifiedDate;
	@NotNull
	private String createdBy;
	@NotNull
	private String modifiedBy;
	boolean isActive ;

}
