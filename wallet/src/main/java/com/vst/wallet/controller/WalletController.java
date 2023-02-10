package com.vst.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import com.vst.wallet.converter.WalletConverter;
import com.vst.wallet.dto.WalletDTO;
import com.vst.wallet.exception.WalletException;
import com.vst.wallet.model.Wallet;
import com.vst.wallet.service.SequenceGeneratorService;
import com.vst.wallet.service.WalletServiceImpl;


import java.util.List;



@RestController
public class WalletController {

	@Autowired
	WalletServiceImpl walletServiceImpl;
	@Autowired
	SequenceGeneratorService generatorService;
	@Autowired
	WalletConverter converter;

	

// for creating the wallet
	@PostMapping("/api/addwallet")
	public ResponseEntity<String> create(@RequestBody WalletDTO walletDTO) {

		walletServiceImpl.createWallet(walletDTO);
		return new ResponseEntity<>("Your is WalletCreated ", HttpStatus.OK);
	}

//for getting wallet amount delete
	@GetMapping("/api/getwalletinfo{walletId}")
	public ResponseEntity<Wallet> getWalletInfo(@PathVariable String walletId) {
		if (walletId != null) {
			Wallet obj = walletServiceImpl.findByWalletId(walletId);
			if (obj != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else {
				throw new WalletException("Data not exist");

			}
		}
		throw new WalletException("Please Enter Valid id");

	}
	@DeleteMapping("/api/deletewallet/{walletId}")
	public ResponseEntity<String> deleteWallet(@PathVariable String walletId) {
		
		if (walletId !=null) {
	walletServiceImpl.deleteWalletByWalletId(walletId);
			return new ResponseEntity<>("Data Deleted",HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/api/updatewallet/{walletId}")
	public ResponseEntity<String> updateWallet(@PathVariable String walletId, @RequestBody WalletDTO walletDTO) {
		if (walletServiceImpl.updatewalletInfo(walletId, walletDTO))

			return new ResponseEntity<>("Your support updateSuccessfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("support not updated", HttpStatus.NOT_ACCEPTABLE);

	}

	@GetMapping("/api/getallwalletinfo")
	public ResponseEntity<List<Wallet>> showAllWallet() {
		List<Wallet> list = walletServiceImpl.getAllWallet();
		if (list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	}

}
