package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.customerOrderDto;

public interface customerCakeBuyNowDao {

	public void buyNow(String customerId, int cakeId, int cakePrice, int ordersQuantity) throws Exception;

	public int buyNowInfo(String customerId) throws Exception;

	public void detailOptionInsert(int ordersId, int cakeoptionId, String customerId, int cakeId,
			String detailoptionLettering, String detailoptionPickupDate) throws Exception;

	public int selectOptionPrice(int ordersId) throws Exception;

	public void salePriceUpdate(int ordersId, int optionPrice, int cakePrice, int ordersQuantity, int ordersSalePrice)
			throws Exception;

	public List<customerOrderDto> orderList(String customerId, int ordersId) throws Exception;

	public List<customerOrderDto> customerInfo(String customerId) throws Exception;
}
