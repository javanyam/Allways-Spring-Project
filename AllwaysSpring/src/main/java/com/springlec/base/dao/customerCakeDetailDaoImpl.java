package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.customerCakeDetailDto;

public class customerCakeDetailDaoImpl implements customerCakeDetailDao {
	
	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.customerCakeDetailDao";

	@Override
	public customerCakeDetailDto customerCakeDetail(int cakeId) throws Exception {
		// TODO Auto-generated method stub
		return (customerCakeDetailDto) sqlSession.selectList(nameSpace + ".customerCakeDetail");
	}

	@Override
	public List<customerCakeDetailDto> customerCakeShape() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".customerCakeShape");
	}

	@Override
	public List<customerCakeDetailDto> customerCakeSize() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".customerCakeSize");
	}

	@Override
	public List<customerCakeDetailDto> customerCakeFlavor() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".customerCakeFlavor");
	}

}
