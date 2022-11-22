package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.managerOrderStatusDto;
import com.springlec.base.model.ordersReviewDto;

public class managerMainDaoImpl implements managerMainDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.managerMainDao";

	@Override
	public List<String> makeXAxis() throws Exception {
		return sqlSession.selectList(nameSpace + ".makeXAxis");
	}
	
	@Override
	public List<Integer> makeSalesPrice() throws Exception {
		return sqlSession.selectList(nameSpace + ".makeSalesPrice");
	}
	
	@Override
	public List<Integer> makeSalesQuantity() throws Exception {
		return sqlSession.selectList(nameSpace + ".makeSalesQuantity");
	}

	@Override
	public List<managerOrderStatusDto> orderStautsList() throws Exception {
		return sqlSession.selectList(nameSpace + ".orderStautsList");
	}

	@Override
	public List<ordersReviewDto> showOrdersReviewOnMain() throws Exception {
		return sqlSession.selectList(nameSpace + ".showOrdersReviewOnMain");
	}
	
}
