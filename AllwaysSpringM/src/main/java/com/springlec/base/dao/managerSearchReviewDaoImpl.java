package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.managerReviewDetailDto;
import com.springlec.base.model.managerReviewListDto;

public class managerSearchReviewDaoImpl implements managerSearchReviewDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.managerSearchReviewDao";

	@Override
	public List<managerReviewListDto> searchReview(String query, String content) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".searchReview");
	}

	@Override
	public managerReviewDetailDto reviewDetail(int oreviewId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".reviewDetail");
	}



	
	
}
