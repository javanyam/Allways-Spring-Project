package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.customerBoardDto;

public interface customerBoardDao {

	public int selectWriteId() throws Exception;
	public List<customerBoardDto> customerBoardList(String combo, String searchContent) throws Exception;
	public void customerBoardWrite(String customerId, String writeTitle, String writeContent, int writeId) throws Exception;
	
}
