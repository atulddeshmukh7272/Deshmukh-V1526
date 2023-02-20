package com.vst.support.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.support.dto.SupportDto;
import com.vst.support.exception.SupportException;
import com.vst.support.model.Support;
import com.vst.support.service.SupportServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/vst1")
public class SupportController {
	@Autowired
	SupportServiceImpl supportServiceImpl;

//for add support
	@PostMapping("/support")
	public ResponseEntity<String> addSupport(@Valid @RequestBody SupportDto supportDto) {
		supportServiceImpl.add(supportDto);
		return new ResponseEntity<>("Support Added Succesfully", HttpStatus.OK);
	}

	// for get support information
	@GetMapping("/support")
	public ResponseEntity<Support> getFeedbackInfo(@RequestParam("supportId") String supportId) {

		return ResponseEntity.ok(supportServiceImpl.show(supportId));
	}

	// for showing all the support to user
	@GetMapping("/supports")
	public ResponseEntity<List<Support>> showAllSupport() {
		return ResponseEntity.ok(supportServiceImpl.showAll());
	}

	// for updating the feedback
	@PutMapping("/support")
	public ResponseEntity<String> updateSupport(@RequestParam("supportId") String supportId,
			@RequestBody SupportDto supportDto) {
		System.out.println(supportId);
		supportServiceImpl.edit(supportId, supportDto);
		return new ResponseEntity<>("deteils update Successfully", HttpStatus.OK);
	}

	// for soft delete
	@DeleteMapping("/support")
	public ResponseEntity<String> deleteSupport(@RequestParam("supportId") String supportId) {
		supportServiceImpl.remove(supportId);
		return new ResponseEntity<>("Support DeleTed", HttpStatus.OK);

	}

}