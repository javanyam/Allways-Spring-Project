package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

public class customerCakeCartInsertDaoImpl implements customerCakeCartInsertDao {
	
	SqlSession sqlSession;
	
	public static String namespace = "com.springlec.base.dao.customerCakeCartInsertDao";

	@Override
	public void cakeCartInsert(String o_customerId, int o_cakeId, int ordersSalePrice, int ordersQuantity)
			throws Exception {
		
		sqlSession.insert(namespace + ".cakeCartInsert");
	}

}
