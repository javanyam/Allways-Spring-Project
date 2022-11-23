package com.springlec.base.model;

import java.sql.Timestamp;

public class managerReviewDetailDto {

	int oreviewId;
	String or_customerId;
	String customerName;
	String cakeName;
	String or_goodsName;
	String oreviewContent;
	int oreviewStarrating;
	String oreviewImage;
	
	Timestamp oreviewInitdate;
	Timestamp oreviewUpadatedate;
	
	public managerReviewDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public managerReviewDetailDto(int oreviewId, String customerName, String cakeName, String or_goodsName,
			int oreviewStarrating, String oreviewContent, String oreviewImage, Timestamp oreviewInitdate,
			Timestamp oreviewUpadatedate) {
		super();
		this.oreviewId = oreviewId;
		this.customerName = customerName;
		this.cakeName = cakeName;
		this.or_goodsName = or_goodsName;
		this.oreviewStarrating = oreviewStarrating;
		this.oreviewContent = oreviewContent;
		this.oreviewImage = oreviewImage;
		this.oreviewInitdate = oreviewInitdate;
		this.oreviewUpadatedate = oreviewUpadatedate;
	}
	
	public int getOreviewId() {
		return oreviewId;
	}

	public void setOreviewId(int oreviewId) {
		this.oreviewId = oreviewId;
	}

	public String getOr_customerId() {
		return or_customerId;
	}

	public void setOr_customerId(String or_customerId) {
		this.or_customerId = or_customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}

	public String getOr_goodsName() {
		return or_goodsName;
	}

	public void setOr_goodsName(String or_goodsName) {
		this.or_goodsName = or_goodsName;
	}

	public String getOreviewContent() {
		return oreviewContent;
	}

	public void setOreviewContent(String oreviewContent) {
		this.oreviewContent = oreviewContent;
	}

	public int getOreviewStarrating() {
		return oreviewStarrating;
	}

	public void setOreviewStarrating(int oreviewStarrating) {
		this.oreviewStarrating = oreviewStarrating;
	}

	public String getOreviewImage() {
		return oreviewImage;
	}

	public void setOreviewImage(String oreviewImage) {
		this.oreviewImage = oreviewImage;
	}

	public Timestamp getOreviewInitdate() {
		return oreviewInitdate;
	}

	public void setOreviewInitdate(Timestamp oreviewInitdate) {
		this.oreviewInitdate = oreviewInitdate;
	}

	public Timestamp getOreviewUpadatedate() {
		return oreviewUpadatedate;
	}

	public void setOreviewUpadatedate(Timestamp oreviewUpadatedate) {
		this.oreviewUpadatedate = oreviewUpadatedate;
	}

	
	
}
