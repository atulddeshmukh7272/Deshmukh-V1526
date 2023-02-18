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
	@NotBlank@NotNull(message="Wallet balance must be provided")
	private String walletAmount;
	@NotBlank@NotNull(message="Wallet currency must be provided")
	private String walletCurrency;
	@NotBlank@NotNull
	private String walletStatus;
	@NotBlank@NotNull
	private String walletType;
	@NotBlank@NotNull
	private String walletPaymentType;
    @NotBlank@NotNull
	private String walletHistory;
	@NotBlank@NotNull
	private String createDate;
	@NotBlank@NotNull
	private String modifiedDate;
	@NotBlank@NotNull
	private String createdBy;
	@NotBlank@NotNull
	private String modifiedBy;
	boolean isActive ;

}
