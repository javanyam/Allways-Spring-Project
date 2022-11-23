package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

public class customerFindUserDaoImpl implements customerFindUserDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.customerFindUserDao";
	
	@Override
	public String findIdDao(String customerName, String customerBirthday, String customerPhone, String customerEmail) throws Exception {
		return sqlSession.selectOne(nameSpace + ".findIdDao");
	}

	@Override
	public int userCheckDao(String customerId, String customerName, String customerBirthday, String customerPhone,
			String customerEmail) throws Exception {
		return sqlSession.selectOne(nameSpace + ".userCheckDao");
	}

	@Override
	public void resetPwDao(String customerId, String customerPw) throws Exception {
		sqlSession.update(nameSpace + ".resetPwDao");
	}

}
