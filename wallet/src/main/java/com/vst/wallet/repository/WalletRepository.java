package com.vst.wallet.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vst.wallet.model.Wallet;

@Repository
public interface WalletRepository extends MongoRepository<Wallet, String> {
	
	Wallet findByWalletIdAndIsActiveTrue(String walletId);

	List<Wallet> findAllByIsActiveTrue();

}
