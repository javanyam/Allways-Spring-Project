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

	@Override
	public int cakeOrdersInfo(String customerId) throws Exception {

		return sqlSession.selectOne(customerId);
	}

	@Override
	public void detailOptionInsert(int ordersId, int cakeoptionId, String customerId, int cakeId,
			String detailoptionLettering, String detailoptionPickupDate) throws Exception {
		// TODO Auto-generated method stub
		
		sqlSession.insert(namespace + ".detailOptionInsert");
	}

	@Override
	public int selectOptionPrice(int ordersId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".selectOptionPrice");
	}

	@Override
	public void salePriceUpdate(int ordersId, int optionPrice, int cakePrice, int ordersQuantity, int ordersSalePrice) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".salePriceUpdate");
	}

}
