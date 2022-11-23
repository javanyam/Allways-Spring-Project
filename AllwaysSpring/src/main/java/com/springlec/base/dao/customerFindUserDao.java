package com.springlec.base.dao;

public interface customerFindUserDao {
	
	public String findIdDao(String customerName, String customerBirthday, String customerPhone, String customerEmail) throws Exception;
	public int userCheckDao(String customerId, String customerName, String customerBirthday, String customerPhone, String customerEmail) throws Exception;
	public void resetPwDao(String customerId, String customerPw) throws Exception;
	
}
