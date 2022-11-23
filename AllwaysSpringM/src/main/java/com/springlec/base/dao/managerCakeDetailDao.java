package com.springlec.base.dao;


import com.springlec.base.model.managerCakeDetailDto;

public interface managerCakeDetailDao {

	public managerCakeDetailDto cakeDetail(String cakeName) throws Exception;
	public void updateCake(String cakeName, int cakePrice, String cakeDetail, int cakeId) throws Exception;
	public void updateCake(String cakeName, int cakePrice, String cakeDetail, int cakeId, String cakeImage) throws Exception;
	public int checkName2(String cakeNewName, String cakeOriginalName) throws Exception;
	public int findCakeId(String cakeOriginalName) throws Exception;
	public void deleteCake(int cakeId) throws Exception;
	
}
