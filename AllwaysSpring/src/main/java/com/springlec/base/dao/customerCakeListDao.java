package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.customerCakeListDto;

public interface customerCakeListDao {
	
	public List<customerCakeListDto> customerCakeList (String sort1, String sort2) throws Exception;
	
}
