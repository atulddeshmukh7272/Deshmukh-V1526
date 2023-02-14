package com.vst.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vst.wallet.dto.WalletDto;
import com.vst.wallet.exception.WalletException;
import com.vst.wallet.model.Wallet;
import com.vst.wallet.service.SequenceGeneratorService;
import com.vst.wallet.service.WalletServiceImpl;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("vst1/wallet")
public class WalletController {

	@Autowired
	WalletServiceImpl walletServiceImpl;

	@Autowired
	SequenceGeneratorService generatorService;

	public static final Logger logger = LogManager.getLogger(WalletController.class);

// for creating the wallet
	@PostMapping
	public ResponseEntity<String> addWallet(@Valid @RequestBody WalletDto walletDto) {
		WalletDto walletdto = walletServiceImpl.add(walletDto);
		if (walletdto != null) {
			return new ResponseEntity<>("Your Wallet Is Created ", HttpStatus.OK);

		} else {
			logger.error("Somthing Went Wrong");
			return new ResponseEntity<>("Wallet Is Not Created", HttpStatus.NOT_ACCEPTABLE);
		}
	}

//for getting wallet amount 
	@GetMapping
	public ResponseEntity<Wallet> getWallet(@RequestParam("walletId") String walletId) {
		if (walletId != null) {
			Wallet obj = walletServiceImpl.show(walletId);
			if (obj != null) {
				return new ResponseEntity<>(obj, HttpStatus.OK);
			} else {
				throw new WalletException("Data not exist");
			}
		}
		throw new WalletException("Please Enter Valid id");

	}

	@GetMapping("s")
	public ResponseEntity<List<Wallet>> getAllWallet() {
		List<Wallet> list = walletServiceImpl.showAll();
		if (list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
	}

	@PutMapping
	public ResponseEntity<String> updateWallet(@RequestParam("walletId") String walletId, @RequestBody WalletDto walletDto) {
		if (walletServiceImpl.edit(walletId, walletDto))

			return new ResponseEntity<>("Your support updateSuccessfully", HttpStatus.OK);
		else
			logger.error("entered id or details are not correct");
		return new ResponseEntity<>("support not updated", HttpStatus.NOT_ACCEPTABLE);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteWallet(@RequestParam("walletId") String walletId) {
		if (walletId != null) {
			walletServiceImpl.remove(walletId);
			return new ResponseEntity<>("Data Deleted", HttpStatus.OK);
		} else {
			logger.error("Entered id is not correct");
			return new ResponseEntity<>("Please enter valid charger id", HttpStatus.BAD_REQUEST);
		}
	}
}
