package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.customerOrderDto;

public class customerCakeBuyNowDaoImpl implements customerCakeBuyNowDao {

	SqlSession sqlSession;

	public static String namespace = "com.springlec.base.dao.customerCakeBuyNowDao";

	@Override
	public void buyNow(String customerId, int cakeId, int cakePrice, int ordersQuantity) throws Exception {

		sqlSession.insert(namespace + ".buyNow");
	}

	@Override
	public int buyNowInfo(String customerId) throws Exception {

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
	public void salePriceUpdate(int ordersId, int optionPrice, int cakePrice, int ordersQuantity, int ordersSalePrice)
			throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".salePriceUpdate");

	}

	@Override
	public List<customerOrderDto> orderList(String customerId, int ordersId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".orderList");
	}

	@Override
	public List<customerOrderDto> customerInfo(String customerId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".customerInfo");
	}
}
