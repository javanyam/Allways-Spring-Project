package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.managerOrderStatusDto;
import com.springlec.base.model.ordersReviewDto;

public interface managerMainDao {

	public List<String> makeXAxis() throws Exception;
	public List<Integer> makeSalesPrice() throws Exception;
	public List<Integer> makeSalesQuantity() throws Exception;
	public List<managerOrderStatusDto> orderStautsList() throws Exception;
	public List<ordersReviewDto> showOrdersReviewOnMain() throws Exception;
	
}
