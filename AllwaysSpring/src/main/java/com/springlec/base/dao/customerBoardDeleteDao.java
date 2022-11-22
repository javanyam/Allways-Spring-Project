package com.springlec.base.dao;


public interface customerBoardDeleteDao {

	public void customerBoardDelete(int writeId, String result) throws Exception;
	public void customerBoardDetailCommentDelete(int commentId, String result) throws Exception;
	
}