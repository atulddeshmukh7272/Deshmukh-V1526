package com.vst.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.vst.wallet.converter.WalletConverter;
import com.vst.wallet.dto.WalletDTO;
import com.vst.wallet.exception.WalletException;
import com.vst.wallet.model.Wallet;
import com.vst.wallet.repository.WalletRepository;

@Service
public class WalletServiceImpl implements WalletInterface {
	@Autowired
	WalletRepository walletRepository;
	@Autowired
	WalletConverter converter;
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@Override
	@Transactional
	public String createWallet(WalletDTO walletDTO) {
		walletDTO.setWalletId(sequenceGeneratorService.idGenerator());
		walletDTO.setActive(true);
		Wallet wallet = converter.dtoToEntity(walletDTO);
		if (walletRepository.save(wallet) != null) {
			return "wallet create successfully";
		} else
			throw new WalletException("wallet is not created");

	}

	@Override
	public Wallet findByWalletId(String walletId) {
		Wallet obj = walletRepository.findByWalletIdAndIsActiveTrue(walletId);
		if (obj != null)
			return obj;
		else
			throw new WalletException("Not Found");
	}

	@Override
	public boolean deleteWalletByWalletId(String wallet) {
		Wallet obj = walletRepository.findByWalletIdAndIsActiveTrue(wallet); // soft delete

		
		if (obj != null) {
			obj.setActive(false);
			walletRepository.save(obj);
			return true;
		} else
			return false;
	}

	@Override
	public boolean updatewalletInfo(String walletId, WalletDTO walletDTO) {

		Wallet wallet = converter.dtoToEntity(walletDTO);
		Wallet obj = walletRepository.findByWalletIdAndIsActiveTrue(walletId);
		if (obj != null) {
			if (wallet.getWalletAmount() != null)
				obj.setWalletAmount(wallet.getWalletAmount());
			if (wallet.getWalletCurrency() != null)
				obj.setWalletCurrency(wallet.getWalletCurrency());
			if (wallet.getWalletStatus() != null)
				obj.setWalletStatus(wallet.getWalletStatus());
			if (wallet.getWalletType() != null)
				obj.setWalletType(wallet.getWalletType());
			if (wallet.getWalletPaymentType() != null)
				obj.setWalletPaymentType(wallet.getWalletPaymentType());
			if (wallet.getWalletHistory() != null)
				obj.setWalletHistory(wallet.getWalletHistory());
			if (wallet.getCreateDate() != null)
				obj.setCreateDate(wallet.getCreateDate());
			if (wallet.getModifiedDate() != null)
				obj.setModifiedDate(wallet.getModifiedDate());
			if (wallet.getCreatedBy() != null)
				obj.setCreatedBy(wallet.getCreatedBy());
			if (wallet.getModifiedBy() != null)
				obj.setModifiedBy(wallet.getModifiedBy());
			walletRepository.save(obj);
			return true;
		}
		throw new WalletException("This Wallet Information Not Exist...!");

	}

	@Override
	public List<Wallet> getAllWallet() {
		return walletRepository.findAllByIsActiveTrue();
	}

	


	

}
