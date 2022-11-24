package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.customerCakeDetailDto;

public class customerCakeDetailDaoImpl implements customerCakeDetailDao {
	
	SqlSession sqlSession;
	
	public static String namespace = "com.springlec.base.dao.customerCakeDetailDao";

	@Override
	public customerCakeDetailDto customerCakeDetail(int cakeId) throws Exception {
		// TODO Auto-generated method stub
		return (customerCakeDetailDto) sqlSession.selectList(namespace + ".customerCakeDetail");
	}

	@Override
	public List<customerCakeDetailDto> customerCakeShape() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".customerCakeShape");
	}

	@Override
	public List<customerCakeDetailDto> customerCakeSize() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".customerCakeSize");
	}

	@Override
	public List<customerCakeDetailDto> customerCakeFlavor() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".customerCakeFlavor");
	}

	@Override
	public void viewsUpdate(int cakeId) throws Exception {
		// TODO Auto-generated method stub
		
		sqlSession.update(namespace + ".viewsUpdate");
	}

}
