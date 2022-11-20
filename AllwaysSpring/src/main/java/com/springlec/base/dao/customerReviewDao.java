package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.customerReviewDto;

public interface customerReviewDao {

	public List<customerReviewDto> customerReviewList(String combo, String searchContent, String sort) throws Exception;
//	public List<customerReviewDto> customerReviewList(String combo, String searchContent, String sort) throws Exception;
	
}
