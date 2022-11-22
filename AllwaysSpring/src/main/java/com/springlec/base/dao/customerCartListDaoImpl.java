package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.customerCartListDto;

public class customerCartListDaoImpl implements customerCartListDao {

	SqlSession sqlSession;

	public static String namespace = "com.springlec.base.dao.customerCartListDao";

	@Override
	public List<customerCartListDto> cakeCartList(String customerId) {
		
		return sqlSession.selectList(namespace + ".cakeCartList");
	}

//	@Override
//	public List<customerCartListDto> optionCartList(String customerId) {
//		// TODO Auto-generated method stub
//		return sqlSession.selectList(namespace + ".optionCartList");
//	}

}
