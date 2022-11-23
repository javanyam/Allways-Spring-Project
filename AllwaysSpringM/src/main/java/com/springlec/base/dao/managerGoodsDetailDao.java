package com.springlec.base.dao;


import com.springlec.base.model.managerGoodsDetailDto;

public interface managerGoodsDetailDao {

	public managerGoodsDetailDto viewGoodsDetail(String goodsName) throws Exception;
	
	public int checkGoodsName2(String goodsName, String goodsOriginalName) throws Exception;
	
	public void deleteGoods(String goodsName) throws Exception;
	
	public void updateGoods(String goodsName, String goodsCategory, int goodsPrice, String goodsDetail, String goodsOriginalname, String originalName) throws Exception;
	
}
