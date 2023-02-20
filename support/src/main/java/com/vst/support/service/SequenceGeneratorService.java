package com.vst.support.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.vst.support.dto.SupportDto;
import com.vst.support.model.DataBaseSequence;


@Service
public class SequenceGeneratorService {

	@Autowired
	private MongoOperations mongoOperations;

	public int getSequenceNumber(String seqName) {
		Query query = new Query(Criteria.where("id").is(seqName)); // update the sequence number
		Update update = new Update().inc("seq", 1); // update in the in document
		DataBaseSequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true),
				DataBaseSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}

	public String idGenerator() {
		Date dNow = new Date();
		SimpleDateFormat dateFormate = new SimpleDateFormat("ddMMyyyy_hhmmss");
		String datetime = dateFormate.format(dNow);
		String id = datetime + "_" + getSequenceNumber(SupportDto.SEQUENCE_NAME);
		return id;
	}
}
