package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

public class customerLoginDaoImpl implements customerLoginDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.customerLoginDao";
	
	@Override
	public int usercheckDao(String customerId, String customerPw) throws Exception {
		return sqlSession.selectOne(nameSpace + ".usercheckDao");
	}

	@Override
	public String usernameDao(String customerId, String customerPw) throws Exception {
		return sqlSession.selectOne(nameSpace + ".usernameDao");
	}


}
