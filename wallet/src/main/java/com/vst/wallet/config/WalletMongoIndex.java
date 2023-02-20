package com.vst.wallet.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;

public class WalletMongoIndex {
	 @Autowired
	    private MongoTemplate mongoTemplate;

//	    @PostConstruct
//	    public void Indexes() {
//	        IndexOperations indexOps = mongoTemplate.indexOps(User.class);
//	        indexOps.ensureIndex(new Index().on("", Direction.ASC).unique());
//	    }
	 
	 
	 
	}


