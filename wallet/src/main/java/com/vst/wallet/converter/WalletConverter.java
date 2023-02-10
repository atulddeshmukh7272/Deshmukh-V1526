package com.vst.wallet.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


import com.vst.wallet.dto.WalletDTO;
import com.vst.wallet.model.Wallet;

@Component
public class WalletConverter {
	public Wallet dtoToEntity(WalletDTO walletDTO) {
		Wallet wallet=new Wallet();
		BeanUtils.copyProperties(walletDTO, wallet);
		return wallet;
		
		
		}
		public WalletDTO entityToDto(Wallet wallet) {
			WalletDTO walletDTO=new WalletDTO();
			BeanUtils.copyProperties(wallet,walletDTO);
			return walletDTO;
		}


}
