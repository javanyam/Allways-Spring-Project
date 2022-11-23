package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.customerOrderDto;

public class customerOrderDaoImpl implements customerOrderDao {
	
	SqlSession sqlSession;

	public static String namespace = "com.springlec.base.dao.customerOrderDao";

	@Override
	public customerOrderDto orderList(String customerId, String ordersId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".orderList");
	}

	@Override
	public List<customerOrderDto> customerInfo(String customerId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".customerInfo");
	}

}
