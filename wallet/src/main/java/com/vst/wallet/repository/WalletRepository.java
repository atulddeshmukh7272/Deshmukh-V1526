package com.vst.wallet.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.vst.wallet.model.Wallet;


public interface WalletRepository extends MongoRepository<Wallet, String> {
	
	Wallet findByWalletIdAndIsActiveTrue(String walletId);

	List<Wallet> findAllByIsActiveTrue();

	
	
}
