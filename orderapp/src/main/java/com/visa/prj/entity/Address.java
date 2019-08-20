package com.visa.prj.entity;

public class Address {
	private int houseNo;
	private String street;
	private String city;
	private String zipcode;
	public Address() {
	}
	public Address(int houseNo, String street, String city, String zipcode) {
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	
}
