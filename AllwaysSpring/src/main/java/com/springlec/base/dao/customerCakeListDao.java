package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.customerCakeListDto;

public interface customerCakeListDao {
	
	public List<customerCakeListDto> customerCakeList (int cakeId, String cakeName, int cakePrice, int cakeViews, int cakeLike) throws Exception;
	
}
