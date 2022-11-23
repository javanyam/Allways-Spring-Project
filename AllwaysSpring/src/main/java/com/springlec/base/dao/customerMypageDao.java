package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.customerMyPointDto;
import com.springlec.base.model.customerOrderListDto;
import com.springlec.base.model.customerUserinfoDto;

public interface customerMypageDao {

	public customerUserinfoDto mypageDao(String customerId) throws Exception;
	public String userEmailDao(String customerId) throws Exception;
	public void updateDao(String customerId, String customerPw, String customerName, String customerGender, String customerPhone, String customerEmail, String customerBirthday, String customerPostcode, String customerAddress, String customerAddressDetail) throws Exception;
	public void deleteDao(String customerId) throws Exception;
	public List<customerOrderListDto> myOrderListDao(String customerId) throws Exception;
	public List<customerMyPointDto> myPointDao(String customerId) throws Exception;
	
	
} // End
