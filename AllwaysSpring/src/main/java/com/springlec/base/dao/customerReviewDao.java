package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.customerOrderListDto;
import com.springlec.base.model.customerPageDto;
import com.springlec.base.model.customerReviewDto;

public interface customerReviewDao {

	public List<customerReviewDto> customerReviewList(String combo, String searchContent, String sort) throws Exception;
	public customerPageDto customerReviewListCount() throws Exception;
	public List<customerOrderListDto> customerOrderList(String customerId) throws Exception;
	public void customerWriteReview(String or_customerId, int or_ordersId, String oreviewContent, 
			String oreviewStarRating, String oreviewImage, int or_cakeId) throws Exception;
	public void writeReviewUpdate(int or_ordersId);
	
}