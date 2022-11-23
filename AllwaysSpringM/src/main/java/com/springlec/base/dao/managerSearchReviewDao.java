package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.managerReviewDetailDto;
import com.springlec.base.model.managerReviewListDto;

public interface managerSearchReviewDao {

	public List<managerReviewListDto> searchReview(String query, String content) throws Exception;
	
	public managerReviewDetailDto reviewDetail(int oreviewId) throws Exception;
	
}
