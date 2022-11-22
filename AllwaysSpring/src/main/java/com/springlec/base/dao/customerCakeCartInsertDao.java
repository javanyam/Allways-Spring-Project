package com.springlec.base.dao;

public interface customerCakeCartInsertDao {
	
	public void cakeCartInsert(String o_customerId, int o_cakeId, int ordersSalePrice, int ordersQuantity) throws Exception;
}
