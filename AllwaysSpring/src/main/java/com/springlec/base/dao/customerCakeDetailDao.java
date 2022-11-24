package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.customerCakeDetailDto;

public interface customerCakeDetailDao {
	
	public customerCakeDetailDto customerCakeDetail(int cakeId) throws Exception;
	
	public List<customerCakeDetailDto> customerCakeShape() throws Exception;
	
	public List<customerCakeDetailDto> customerCakeSize() throws Exception;
	
	public List<customerCakeDetailDto> customerCakeFlavor() throws Exception;
	
	public void viewsUpdate(int cakeId) throws Exception;

}
