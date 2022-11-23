package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.managerGoodsDto;

public interface managerGoodsDao {

	public List<managerGoodsDto> viewGoodsList1() throws Exception;
	
	public List<managerGoodsDto> viewGoodsList2(String goodsCategory) throws Exception;

	public List<managerGoodsDto> searchGoods1(String goodsName) throws Exception;
	
	public List<managerGoodsDto> searchGoods2(String goodsName, String goodsCategory) throws Exception;
	
	public void addGoods(String goodsName, String goodsCategory, int goodsPrice, String goodsDetail, String goodsImage) throws Exception;
	
	public int checkGoodsName(String goodsName) throws Exception;
	
}
