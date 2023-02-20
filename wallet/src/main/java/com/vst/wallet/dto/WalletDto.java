package com.vst.wallet.dto;

import javax.validation.constraints.NotBlank;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WalletDto {
	@Transient
	public static final String SEQUENCE_NAME = "wallet_sequnce"; // for generating the id

	@Id
	private String walletId;
	@NotNull(message="Wallet balance must be provided")
	@NotBlank
	private String walletAmount;
	@NotNull(message="Wallet currency must be provided")
	@NotBlank
	private String walletCurrency;
	@NotNull
	@NotBlank
	private String walletStatus;
	@NotNull
	@NotBlank
	private String walletType;
	@NotNull
	@NotBlank
	private String walletPaymentType;
	@NotNull
    @NotBlank
	private String walletHistory;
    @NotNull
	@NotBlank
	private String createDate;
	@NotNull
	@NotBlank
	private String modifiedDate;
	@NotNull
	@NotBlank
	private String createdBy;
	@NotNull
	@NotBlank
	private String modifiedBy;
	boolean isActive ;

}
