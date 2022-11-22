package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.springlec.base.model.customerCartListDto;

public interface customerCartListDaoService {
	
	public List<customerCartListDto> cakeCartList(HttpSession session) throws Exception;
	
//	public List<customerCartListDto> optionCartList(HttpServletRequest request) throws Exception;

}
