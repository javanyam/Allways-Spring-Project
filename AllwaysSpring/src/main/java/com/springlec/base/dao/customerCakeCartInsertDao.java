package com.springlec.base.dao;

public interface customerCakeCartInsertDao {
	
	public void cakeCartInsert(String o_customerId, int o_cakeId, int ordersSalePrice, int ordersQuantity) throws Exception;
	
	public int cakeOrdersInfo(String customerId) throws Exception;
	
	public void detailOptionInsert(int ordersId, int cakeoptionId, String customerId, int cakeId, String detailoptionLettering, String detailoptionPickupDate) throws Exception;
	
	public int selectOptionPrice(int ordersId) throws Exception;
	
	public void salePriceUpdate(int ordersId, int optionPrice, int cakePrice, int ordersQuantity, int ordersSalePrice) throws Exception;
}
