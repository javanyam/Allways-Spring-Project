package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.customerCartListDto;

public interface customerCartListDao {

	public List<customerCartListDto> cakeCartList(String customerId);

//	public List<customerCartListDto> optionCartList(String customerId);

}
