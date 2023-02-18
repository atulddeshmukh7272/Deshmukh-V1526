package com.vst.wallet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.vst.wallet.converter.WalletConverter;
import com.vst.wallet.dto.WalletDto;
import com.vst.wallet.model.Wallet;
import com.vst.wallet.repository.WalletRepository;
import com.vst.wallet.service.WalletServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
class WalletApplicationTests {

	@Autowired 
	WalletServiceImpl walletServiceImpl;

	@Autowired
	WalletConverter walletConverter;

	
	@MockBean
	WalletRepository walletRepository;


	@Test
	public void testWalletIsValid() {
		Wallet wallet = new Wallet();
		wallet.setWalletAmount("100.0");
		wallet.setWalletCurrency("USD");
		wallet.setWalletStatus("active");
		wallet.setWalletType("savings");
		wallet.setWalletPaymentType("credit");
		wallet.setWalletHistory("qefef");
		wallet.setCreateDate("14-10-20222");
		wallet.setCreatedBy("15-10-2022");
		wallet.setCreatedBy("vihan");
		wallet.setModifiedBy("John");
		
		WalletDto walletDto=walletConverter.entityToDto(wallet);
		when(walletRepository.save(wallet)).thenReturn(wallet);
		assertEquals("wallet save successfully", walletServiceImpl.add(walletDto));
	}

//	@Test
//	public void addWallet() {
//		Wallet wallet = new Wallet();
//		wallet.setWalletId(sequenceGeneratorService.idGenerator());
//		wallet.setActive(true);
//		WalletDto walletDto = walletConverter.entityToDto(wallet);
//		when(walletRepository.save(wallet)).thenReturn(wallet);
//		assertEquals("Data stored successfully", walletServiceImpl.add(walletDto));
//	}

}
