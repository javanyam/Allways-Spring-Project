package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.customerMyPointDto;
import com.springlec.base.model.customerOrderListDto;
import com.springlec.base.model.customerUserinfoDto;

public class customerMypageDaoImpl implements customerMypageDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.customerMypageDao";

	
	@Override
	public customerUserinfoDto mypageDao(String customerId) throws Exception {
		return (customerUserinfoDto) sqlSession.selectList(nameSpace + ".mypageDao");
	}


	@Override
	public String userEmailDao(String customerId) throws Exception {
		return sqlSession.selectOne(nameSpace + ".userEmailDao");
	}


	@Override
	public void updateDao(String customerId, String customerPw, String customerName, String customerGender,
			String customerPhone, String customerEmail, String customerBirthday, String customerPostcode,
			String customerAddress, String customerAddressDetail) throws Exception {
		sqlSession.update(nameSpace + ".updateDao");
	}


	@Override
	public void deleteDao(String customerId) throws Exception {
		sqlSession.delete(nameSpace + ".deleteDao");
	}


	@Override
	public List<customerOrderListDto> myOrderListDao(String customerId) throws Exception {
		return sqlSession.selectList(nameSpace + ".myOrderListDao");
	}


	@Override
	public List<customerMyPointDto> myPointDao(String customerId) throws Exception {
		return sqlSession.selectList(nameSpace + ".myPointDao");
	}

}
