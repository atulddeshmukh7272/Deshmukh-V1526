package com.vst.wallet.exception;

public class WalletNotFoundException extends RuntimeException {
private static final long serialVersionUID = -5769763253309588650L;
	
	public WalletNotFoundException(String message) {
		super(message);
	}
}
