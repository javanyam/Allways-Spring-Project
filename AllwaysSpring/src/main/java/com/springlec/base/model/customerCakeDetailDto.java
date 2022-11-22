package com.springlec.base.model;

public class customerCakeDetailDto {

	int cakeId;
	String cakeName;
	int cakePrice;
	String cakeImage;
	int cakeLike;
	int cakeViews;
	String cakeDetail;

	int cakeoptionId;
	String cakeoptionCategory;
	String cakeoptionValue;
	int cakeoptionPrice;

	int ordersId;
	String ordersStatus;

	public customerCakeDetailDto(int cakeId, String cakeName, int cakePrice, String cakeImage, int cakeLike,
			int cakeViews, String cakeDetail) {
		super();
		this.cakeId = cakeId;
		this.cakeName = cakeName;
		this.cakePrice = cakePrice;
		this.cakeImage = cakeImage;
		this.cakeLike = cakeLike;
		this.cakeViews = cakeViews;
		this.cakeDetail = cakeDetail;
	}

	public customerCakeDetailDto(int cakeoptionId, String cakeoptionCategory, String cakeoptionValue,
			int cakeoptionPrice) {
		super();
		this.cakeoptionId = cakeoptionId;
		this.cakeoptionCategory = cakeoptionCategory;
		this.cakeoptionValue = cakeoptionValue;
		this.cakeoptionPrice = cakeoptionPrice;
	}

	public int getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}

	public int getCakeId() {
		return cakeId;
	}

	public void setCakeId(int cakeId) {
		this.cakeId = cakeId;
	}

	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}

	public int getCakePrice() {
		return cakePrice;
	}

	public void setCakePrice(int cakePrice) {
		this.cakePrice = cakePrice;
	}

	public String getCakeImage() {
		return cakeImage;
	}

	public void setCakeImage(String cakeImage) {
		this.cakeImage = cakeImage;
	}

	public int getCakeLike() {
		return cakeLike;
	}

	public void setCakeLike(int cakeLike) {
		this.cakeLike = cakeLike;
	}

	public int getCakeViews() {
		return cakeViews;
	}

	public void setCakeViews(int cakeViews) {
		this.cakeViews = cakeViews;
	}

	public String getCakeDetail() {
		return cakeDetail;
	}

	public void setCakeDetail(String cakeDetail) {
		this.cakeDetail = cakeDetail;
	}

	public int getCakeoptionId() {
		return cakeoptionId;
	}

	public void setCakeoptionId(int cakeoptionId) {
		this.cakeoptionId = cakeoptionId;
	}

	public String getCakeoptionCategory() {
		return cakeoptionCategory;
	}

	public void setCakeoptionCategory(String cakeoptionCategory) {
		this.cakeoptionCategory = cakeoptionCategory;
	}

	public String getCakeoptionValue() {
		return cakeoptionValue;
	}

	public void setCakeoptionValue(String cakeoptionValue) {
		this.cakeoptionValue = cakeoptionValue;
	}

	public int getCakeoptionPrice() {
		return cakeoptionPrice;
	}

	public void setCakeoptionPrice(int cakeoptionPrice) {
		this.cakeoptionPrice = cakeoptionPrice;
	}

}
