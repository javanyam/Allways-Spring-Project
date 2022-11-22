package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

public interface customerBoardDeleteDaoService {

	public void customerBoardDelete(HttpServletRequest request) throws Exception;
	public void customerBoardDetailCommentDelete(HttpServletRequest request) throws Exception;
	
}