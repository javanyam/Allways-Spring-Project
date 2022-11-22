package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

public class customerPayDaoImpl implements customerPayDao {
	
	SqlSession sqlSession;
	
	public static String namespace = "com.springlec.base.dao.customerPayDao";

	@Override
	public void pay(String ordersId, String customerId, String cakeId, String ordersSalePrice, String ordersQuantity, int ordersPoint) throws Exception {
		
		sqlSession.insert(namespace + ".pay");
		
	}

	@Override
	public void cartListUpdate(String ordersId) throws Exception {
		
		sqlSession.update(namespace + ".cartListUpdate");
	}

}
