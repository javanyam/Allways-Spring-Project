package com.springlec.base.model;

public class cakeDto {

	int seq;
	String name;
	String phone;
	String address;
	String email;
	String relation;

	public cakeDto() {
		// TODO Auto-generated constructor stub
	}

	public cakeDto(int seq, String name, String phone, String address, String email, String relation) {
		super();
		this.seq = seq;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.relation = relation;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

}
