package com.springlec.base.service;

public interface customerLoginDaoService {
	public int usercheckDao(String customerId, String customerPw) throws Exception;
	public String usernameDao(String customerId, String customerPw) throws Exception;

}
