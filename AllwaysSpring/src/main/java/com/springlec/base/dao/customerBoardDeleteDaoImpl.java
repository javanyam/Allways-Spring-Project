package com.springlec.base.dao;


import org.apache.ibatis.session.SqlSession;


public class customerBoardDeleteDaoImpl implements customerBoardDeleteDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.customerBoardDeleteDao";

	@Override
	public void customerBoardDelete(int writeId, String result) throws Exception {

		sqlSession.update(nameSpace + ".customerBoardDelete");
	}

	@Override
	public void customerBoardDetailCommentDelete(int commentId, String result) throws Exception {
		
		sqlSession.update(nameSpace + ".customerBoardDetailCommentDelete");
	}



	
	
	
	
}