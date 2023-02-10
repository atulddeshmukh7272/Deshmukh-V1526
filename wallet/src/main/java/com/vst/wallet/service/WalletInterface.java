package com.vst.wallet.service;


import java.util.List;


import com.vst.wallet.dto.WalletDTO;
import com.vst.wallet.model.Wallet;

public interface WalletInterface {


public Wallet findByWalletId(String walletId);
 public String createWallet(WalletDTO walletDTO);
public boolean deleteWalletByWalletId(String wallet);
public boolean updatewalletInfo(String walletId, WalletDTO walletDTO);//for update wallet
public List<Wallet> getAllWallet();//return All Wallet


}
