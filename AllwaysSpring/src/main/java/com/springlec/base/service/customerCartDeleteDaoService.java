package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

public interface customerCartDeleteDaoService {
	
	public void optionDelete(HttpServletRequest request) throws Exception;
	
	public void cartDelete(HttpServletRequest request) throws Exception;

}
