package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.customerBoardDetailDto;
import com.springlec.base.model.customerBoardDto;

public interface customerBoardDao {

	public List<customerBoardDto> customerBoardList(String combo, String searchContent) throws Exception;
	public int selectWriteId() throws Exception;
	public void customerBoardWrite(String customerId, String writeTitle, String writeContent, int writeId) throws Exception;
	public customerBoardDetailDto customerBoardDetail(String customerId, int writeId) throws Exception;
	public List<customerBoardDetailDto> customerboardCommentList(int writeId) throws Exception;
	public void customerwriteComment(String customerId, int commentId, String writeContent) throws Exception;
	
}