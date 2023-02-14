package com.vst.wallet.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.vst.wallet.dto.WalletDto;
import com.vst.wallet.model.Wallet;

@Component
public class WalletConverter {
	
	public Wallet dtoToEntity(WalletDto walletDto) {
		Wallet wallet = new Wallet();
		BeanUtils.copyProperties(walletDto, wallet);
		return wallet;
	}

	public WalletDto entityToDto(Wallet wallet) {
		WalletDto walletDto = new WalletDto();
		BeanUtils.copyProperties(wallet, walletDto);
		return walletDto;
	}

}
