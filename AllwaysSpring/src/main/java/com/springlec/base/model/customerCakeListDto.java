package com.springlec.base.model;

public class customerCakeListDto {

	int cakeId;
	String cakeName;
	int cakePrice;
	String cakeImage;
	int cakeViews;
	int cakeLike;

	public customerCakeListDto() {
		// TODO Auto-generated constructor stub
	}

	public customerCakeListDto(int cakeId, String cakeName, int cakePrice, String cakeImage, int cakeViews,
			int cakeLike) {
		super();
		this.cakeId = cakeId;
		this.cakeName = cakeName;
		this.cakePrice = cakePrice;
		this.cakeImage = cakeImage;
		this.cakeViews = cakeViews;
		this.cakeLike = cakeLike;
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

	public int getCakeViews() {
		return cakeViews;
	}

	public void setCakeViews(int cakeViews) {
		this.cakeViews = cakeViews;
	}

	public int getCakeLike() {
		return cakeLike;
	}

	public void setCakeLike(int cakeLike) {
		this.cakeLike = cakeLike;
	}

}