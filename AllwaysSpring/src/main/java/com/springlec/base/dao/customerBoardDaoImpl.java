package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.customerBoardDetailDto;
import com.springlec.base.model.customerBoardDto;

public class customerBoardDaoImpl implements customerBoardDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.customerReviewDao";

	@Override
	public List<customerBoardDto> customerBoardList(String combo, String searchContent) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".customerBoardList");
	}

	@Override
	public int selectWriteId() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".selectWriteId");
	}
	
	@Override
	public void customerBoardWrite(String customerId, String writeTitle, String writeContent, int writeId) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(nameSpace + ".customerBoardWrite");
	}

	@Override
	public customerBoardDetailDto customerBoardDetail(String customerId, int writeId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".customerBoardDetail");
	}

	@Override
	public List<customerBoardDetailDto> customerboardCommentList(int writeId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".customerboardCommentList");
	}

	@Override
	public void customerwriteComment(String customerId, int commentId, String writeContent) throws Exception {

		sqlSession.insert(nameSpace + ".customerwriteComment");
	}

	
	
	
	
}