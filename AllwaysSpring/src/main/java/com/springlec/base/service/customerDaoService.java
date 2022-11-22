package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.cakeDto;

public interface customerDaoService {

	public List<cakeDto> listDao() throws Exception;
	
	public void writeDao(String name, String phone, String address, String email, String relation) throws Exception;

	public cakeDto contentDao(int seq) throws Exception;
	
	public void deleteDao(int seq) throws Exception;
	
	public void updateDao(int seq, String name, String phone, String address, String email, String relation) throws Exception;
	
	public List<cakeDto> searchDao(String query, String content) throws Exception;
}
