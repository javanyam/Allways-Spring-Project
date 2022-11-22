package com.springlec.base.dao;

public interface customerLoginDao {

	public int usercheckDao(String customerId, String customerPw) throws Exception;
	public String usernameDao(String customerId, String customerPw) throws Exception;
	
}
