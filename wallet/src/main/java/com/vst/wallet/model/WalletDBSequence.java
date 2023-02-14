package com.vst.wallet.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "db_sequences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletDBSequence {

	@Id
	private String id;
	private int seq;

}
