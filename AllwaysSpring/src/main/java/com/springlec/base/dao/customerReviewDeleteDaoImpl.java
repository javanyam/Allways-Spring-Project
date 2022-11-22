package com.springlec.base.dao;


import org.apache.ibatis.session.SqlSession;


public class customerReviewDeleteDaoImpl implements customerReviewDeleteDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.customerReviewDeleteDao";

	@Override
	public void customerReviewDelete(int oreviewId) throws Exception {

		sqlSession.update(nameSpace + ".customerReviewDelete");
	}

	
	
}