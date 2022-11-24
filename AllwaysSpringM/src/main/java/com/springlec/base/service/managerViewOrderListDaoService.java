package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.base.model.managerViewOrderListDto;

public interface managerViewOrderListDaoService {
	
	public void orderList1(HttpServletRequest request, Model model) throws Exception;
	public List<managerViewOrderListDto> orderList2() throws Exception;
	public void orderList3(HttpServletRequest request, Model model) throws Exception;
	
	public managerViewOrderListDto orderSelect(HttpServletRequest request) throws Exception;
	
	public void orderDelete(HttpServletRequest request) throws Exception;
	
	public void orderUpdateToMaking(HttpServletRequest request) throws Exception;
	public void orderUpdateMakedate(int ordersId) throws Exception;
	
	public void orderUpdateToDone(HttpServletRequest request) throws Exception;
	public void orderUpdateDonedate(int ordersId) throws Exception;
}
