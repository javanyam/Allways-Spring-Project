package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.managerCakeListDto;

public interface managerCakeDao {

	public List<managerCakeListDto> searchCake(String cakeName) throws Exception;
	public void addCake(String cakeName, int cakePrice, String cakeDetail, String originalName) throws Exception;
	public int cakeNameCheck(String cakeName) throws Exception;
	
}
