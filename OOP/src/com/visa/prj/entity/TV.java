package com.visa.prj.entity;

public class TV extends Product {
	private String screenType;

	public TV() {
	}

	public TV(int id, String name, double price, String screenType) {
		super(id, name, price);
		this.screenType = screenType;
	}

	public String getScreenType() {
		return screenType;
	}

	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}

	@Override
	public boolean isExpensive() {
		if (Math.random() < 0.5)
			return true;
		return false;
	}

	
}
