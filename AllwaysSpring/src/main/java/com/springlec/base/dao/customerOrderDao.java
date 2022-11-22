package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.customerOrderDto;

public interface customerOrderDao {
	
	public List<customerOrderDto> orderList(String customerId, String ordersId) throws Exception;
	
	public List<customerOrderDto> customerInfo(String customerId) throws Exception;

}
