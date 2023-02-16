package com.vst.wallet.service;

import java.util.List;

import com.vst.wallet.dto.WalletDto;
import com.vst.wallet.model.Wallet;

public interface WalletServiceInterface {

	public String add(WalletDto walletDto);

	public Wallet show(String walletId);

	public List<Wallet> showAll();// return All Wallet

	public void edit(String walletId, WalletDto walletDto);// for update wallet

	public void remove(String wallet);

}
