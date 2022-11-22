package com.springlec.base.dao;

public interface customerPayDao {
	
	public void pay(String ordersId, String customerId, String cakeId, String ordersSalePrice, String ordersQuantity, int ordersPoint) throws Exception;
	
	public void cartListUpdate(String ordersId) throws Exception;

}
