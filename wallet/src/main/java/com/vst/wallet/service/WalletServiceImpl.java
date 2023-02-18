package com.vst.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.wallet.converter.WalletConverter;
import com.vst.wallet.dto.WalletDto;
import com.vst.wallet.exception.IdNotAcceptableException;
import com.vst.wallet.exception.WalletException;
import com.vst.wallet.exception.WalletNotFoundException;
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
	public String add(WalletDto walletDto) {
		walletDto.setWalletId(sequenceGeneratorService.idGenerator());
		walletDto.setActive(true);
		Wallet wallet = walletConverter.dtoToEntity(walletDto);
		walletRepository.save(wallet);
		return "wallet save successfully";

	}

//for showing wallet Info
	@Override
	public Wallet show(String walletId) {
		if (!walletId.isBlank()) {

			Wallet wallet = walletRepository.findByWalletIdAndIsActiveTrue(walletId);
			if (wallet != null) {

				return wallet;
			} else {
				throw new WalletNotFoundException("Given Id Is Not Available");
			}
		} else {
			throw new IdNotAcceptableException("Please Enter Correct Id");
		}
	}

	@Override
	public List<Wallet> showAll() {
		List<Wallet> list = walletRepository.findAllByIsActiveTrue();
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new WalletNotFoundException("data is not available");
		}
	}

//for updating the wallet Info
	@Override
	public void edit(String walletId, WalletDto walletDto) {
		if (!walletId.isBlank()) {

			Wallet wallet = walletConverter.dtoToEntity(walletDto);
			Wallet obj = walletRepository.findByWalletIdAndIsActiveTrue(walletId);
			if (obj != null) {
				if (wallet.getWalletAmount()!=null)
				if (!wallet.getWalletAmount().isBlank())
					obj.setWalletAmount(wallet.getWalletAmount());

				if (wallet.getWalletCurrency()!=null)
					if (!wallet.getWalletCurrency().isBlank())
					obj.setWalletCurrency(wallet.getWalletCurrency());

				if (wallet.getWalletStatus()!=null)
					if (!wallet.getWalletStatus().isBlank())
					obj.setWalletStatus(wallet.getWalletStatus());

				if (wallet.getWalletType()!=null)
					if (!wallet.getWalletType().isBlank())
					obj.setWalletType(wallet.getWalletType());

				if (wallet.getWalletPaymentType()!=null)
					if (!wallet.getWalletPaymentType().isBlank())
					obj.setWalletPaymentType(wallet.getWalletPaymentType());
				
				if (wallet.getWalletHistory()!=null)
					if (wallet.getWalletHistory().isBlank())
					obj.setWalletHistory(wallet.getWalletHistory());
				
				if (!wallet.getCreateDate().isBlank())
					obj.setCreateDate(wallet.getCreateDate());
				
				if (!wallet.getModifiedDate().isBlank())
					obj.setModifiedDate(wallet.getModifiedDate());
				
				if (!wallet.getCreatedBy().isBlank())
					obj.setCreatedBy(wallet.getCreatedBy());
				
				if (!wallet.getModifiedBy().isBlank())
					obj.setModifiedBy(wallet.getModifiedBy());
				walletRepository.save(obj);

			} else {
				throw new WalletNotFoundException("Given Id Is Not Present");
			}
		} else {
			throw new IdNotAcceptableException("Please Enter Correct Id");

		}
	}

//deleting the data
	@Override
	public void remove(String walletId) {
		if (!walletId.trim().isEmpty()) {

			Wallet wallet = walletRepository.findByWalletIdAndIsActiveTrue(walletId);
			if (wallet != null) {
				wallet.setActive(false);
				walletRepository.save(wallet);
			} else {
				throw new WalletNotFoundException("Wallet Is Not Found");
			}
		} else {
			throw new IdNotAcceptableException("Given Wallet Id Is Not Found");
		}
	}
}
