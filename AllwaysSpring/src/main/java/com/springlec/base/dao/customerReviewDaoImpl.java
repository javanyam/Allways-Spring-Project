package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.springlec.base.model.customerReviewDto;

public class customerReviewDaoImpl implements customerReviewDao {

	@Autowired
	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.customerReviewDao";

	@Override
	public List<customerReviewDto> customerReviewList(String combo, String searchContent, String sort) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".customerReviewList");
	}
	
	
	
}
