package com.vst.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.wallet.converter.WalletConverter;
import com.vst.wallet.dto.WalletDto;
import com.vst.wallet.exception.WalletException;
import com.vst.wallet.model.Wallet;
import com.vst.wallet.repository.WalletRepository;

@Service
public class WalletServiceImpl implements WalletServiceInterface {
	@Autowired
	WalletRepository walletRepository;

	@Autowired
	WalletConverter walletConverter;

	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

//for adding wallet info
	@Override
	@Transactional
	public WalletDto add(WalletDto walletDto) {
		walletDto.setWalletId(sequenceGeneratorService.idGenerator());
		walletDto.setActive(true);
		Wallet wallet = walletConverter.dtoToEntity(walletDto);
		walletRepository.save(wallet);
		return walletConverter.entityToDto(wallet);

	}

//for showing wallet Info
	@Override
	public Wallet show(String walletId) {
		Wallet obj = walletRepository.findByWalletIdAndIsActiveTrue(walletId);
		if (obj != null)
			return obj;
		else
			throw new WalletException("Not Found");
	}

	@Override
	public List<Wallet> showAll() {
		return walletRepository.findAllByIsActiveTrue();
	}

//for updating the wallet Info
	@Override
	public boolean edit(String walletId, WalletDto walletDto) {

		Wallet wallet = walletConverter.dtoToEntity(walletDto);
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
		
		}else {
			throw new WalletException("This Wallet Information Not Exist...!");
		}
		
		return true;
}

//deleting the data
	@Override
	public boolean remove(String wallet) {
		Wallet obj = walletRepository.findByWalletIdAndIsActiveTrue(wallet); // soft delete

		if (obj != null) {
			obj.setActive(false);
			walletRepository.save(obj);
			return true;
		} else
			return false;
	}
}
