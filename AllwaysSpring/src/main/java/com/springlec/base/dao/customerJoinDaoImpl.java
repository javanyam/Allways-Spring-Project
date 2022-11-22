package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

public class customerJoinDaoImpl implements customerJoinDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.customerJoinDao";
	
	@Override
	public int idcheckDao(String customerId) throws Exception {
		return sqlSession.selectOne(nameSpace + ".idcheckDao");
	}

	@Override
	public void joinDao(String customerId, String customerPw, String customerName, String customerGender,
			String customerPhone, String customerEmail, String customerBirthday, String customerPostcode,
			String customerAddress, String customerAddressDetail) throws Exception {
		sqlSession.insert(nameSpace + ".joinDao");
	}

}
