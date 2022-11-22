package com.springlec.base.dao;

import org.apache.ibatis.session.SqlSession;

public class managerLoginDaoImpl implements managerLoginDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.managerLoginDao";

	@Override
	public int managerLogin(String managerId, String managerPw) throws Exception {
		return sqlSession.selectOne(nameSpace + ".managerLogin");
	}
	
}
