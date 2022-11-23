package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.springlec.base.model.managerViewOrderListDto;

public interface managerViewOrderListDaoService {
	
	public List<managerViewOrderListDto> orderList1() throws Exception;
	public List<managerViewOrderListDto> orderList2() throws Exception;
	public List<managerViewOrderListDto> orderList3() throws Exception;
	
	public managerViewOrderListDto orderSelect(HttpServletRequest request) throws Exception;
	
	public void orderDelete(HttpServletRequest request) throws Exception;
	
	public void orderUpdateToMaking(HttpServletRequest request) throws Exception;
	public void orderUpdateMakedate(int ordersId) throws Exception;
	
	public void orderUpdateToDone(HttpServletRequest request) throws Exception;
	public void orderUpdateDonedate(int ordersId) throws Exception;
}
