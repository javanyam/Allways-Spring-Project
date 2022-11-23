package com.springlec.base.model;

public class managerCakeDetailDto {

	String cakeName;
	int cakePrice;
	String cakeDetail;
	String cakeImage;
	
	public managerCakeDetailDto(String cakeName, int cakePrice, String cakeDetail, String cakeImage) {
		super();
		this.cakeName = cakeName;
		this.cakePrice = cakePrice;
		this.cakeDetail = cakeDetail;
		this.cakeImage = cakeImage;
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
	public String getCakeDetail() {
		return cakeDetail;
	}
	public void setCakeDetail(String cakeDetail) {
		this.cakeDetail = cakeDetail;
	}
	public String getCakeImage() {
		return cakeImage;
	}
	public void setCakeImage(String cakeImage) {
		this.cakeImage = cakeImage;
	}
	
}
