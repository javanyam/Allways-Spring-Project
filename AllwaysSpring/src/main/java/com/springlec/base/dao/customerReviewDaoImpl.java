package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.customerOrderListDto;
import com.springlec.base.model.customerPageDto;
import com.springlec.base.model.customerReviewDto;

public class customerReviewDaoImpl implements customerReviewDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.customerReviewDao";

	@Override
	public List<customerReviewDto> customerReviewList(String combo, String searchContent, String sort) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".customerReviewList");
	}

	@Override
	public customerPageDto customerReviewListCount() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".customerReviewListCount");
	}
	
	@Override
	public List<customerOrderListDto> customerOrderList(String customerId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".customerOrderList");
	}

	@Override
	public void customerWriteReview(String or_customerId, int or_ordersId, String oreviewContent,
			String oreviewStarRating, String oreviewImage, int or_cakeId) throws Exception {

		sqlSession.insert(nameSpace + ".customerWriteReview");
	}

	@Override
	public void writeReviewUpdate(int or_ordersId) {
		
		sqlSession.update(nameSpace + ".writeReviewUpdate");
	}

	

	
	
	
	
}