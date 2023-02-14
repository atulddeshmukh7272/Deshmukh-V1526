package com.vst.wallet.service;

import java.util.List;

import com.vst.wallet.dto.WalletDto;
import com.vst.wallet.model.Wallet;

public interface WalletServiceInterface {

	public WalletDto add(WalletDto walletDto);

	public Wallet show(String walletId);

	public List<Wallet> showAll();// return All Wallet

	public boolean edit(String walletId, WalletDto walletDto);// for update wallet

	public boolean remove(String wallet);

}
