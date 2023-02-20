package com.vst.support.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vst.support.model.Support;

public interface SupportRepository extends MongoRepository<Support, String> {

	public Support findBySupportIdAndIsActiveTrue(String supportId);

	public List<Support> findAllByAndIsActiveTrue();// this is fetching all information from database

}
