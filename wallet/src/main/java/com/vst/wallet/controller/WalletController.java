package com.vst.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.vst.wallet.model.Wallet;
import com.vst.wallet.service.SequenceGeneratorService;
import com.vst.wallet.service.WalletServiceImpl;



import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vst1")
public class WalletController {

	@Autowired
	WalletServiceImpl walletServiceImpl;

	@Autowired
	SequenceGeneratorService generatorService;

	public static final Logger logger = LogManager.getLogger(WalletController.class);

// for creating the wallet
	@PostMapping("wallet")
	public ResponseEntity<String> addWallet(@Valid @RequestBody WalletDto walletDto) {
		walletServiceImpl.add(walletDto);
		return new ResponseEntity<>("Wallet saved Successfully", HttpStatus.OK);

	}

//for getting wallet amount 
	@GetMapping("wallet")
	public ResponseEntity<Wallet> getWallet(@RequestParam("walletId") String walletId) {

		return ResponseEntity.ok(walletServiceImpl.show(walletId));
	}

//for getting all record
	@GetMapping("/wallets")
	public ResponseEntity<List<Wallet>> getAllWallet() {
		return ResponseEntity.ok(walletServiceImpl.showAll());

	}

//for updating record
	@PutMapping("/wallet")
	public ResponseEntity<String> updateWallet(@RequestParam("walletId") String walletId,
			@RequestBody WalletDto walletDto) {
		walletServiceImpl.edit(walletId, walletDto);
		return new ResponseEntity<>("details update Successfully", HttpStatus.OK);

	}

//for deleting record
	@DeleteMapping("/wallet")
	public ResponseEntity<String> deleteWallet(@RequestParam("walletId") String walletId) {

		walletServiceImpl.remove(walletId);
		return new ResponseEntity<>("wallet Deleted", HttpStatus.OK);

	}

}
