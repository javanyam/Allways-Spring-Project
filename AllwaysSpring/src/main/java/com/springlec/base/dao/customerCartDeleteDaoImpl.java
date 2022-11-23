package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

public class customerCartDeleteDaoImpl implements customerCartDeleteDao {
	
	SqlSession sqlSession;
	
	public static String namespace = "com.springlec.base.dao.customerCartDeleteDao";

	@Override
	public void optionDelete(String ordersId) throws Exception {
		
		sqlSession.delete(namespace + ".optionDelete");
	}

	@Override
	public void cartDelete(String ordersId) throws Exception {
		
		sqlSession.delete(namespace + ".cartDelete");
	}

}
