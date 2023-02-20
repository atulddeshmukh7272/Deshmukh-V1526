package com.vst.support.service;

import java.util.List;

import com.vst.support.dto.SupportDto;
import com.vst.support.model.Support;



public interface SupportServiceInterface {
	
	public SupportDto add(SupportDto supportDto);//save support
	public Support show(String supportId);//find support using id
	public List<Support> showAll();//for returning all support
	public void edit(String supportId,SupportDto supportDto);//for update support
	public void remove(String supportId);//soft delete
	
}
