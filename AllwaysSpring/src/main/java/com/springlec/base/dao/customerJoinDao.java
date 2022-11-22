package com.springlec.base.dao;

public interface customerJoinDao {
	public int idcheckDao(String customerId) throws Exception;
	public void joinDao(String customerId, String customerPw, String customerName, String customerGender, String customerPhone, String customerEmail, String customerBirthday, String customerPostcode, String customerAddress, String customerAddressDetail) throws Exception;
}
