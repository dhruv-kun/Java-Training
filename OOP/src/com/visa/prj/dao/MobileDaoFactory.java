package com.visa.prj.dao;

import java.util.ResourceBundle;

public class MobileDaoFactory {
	private static String NAME = "";
	/*
	 * Compulsory executed block
	 */
	static {
		ResourceBundle res = ResourceBundle.getBundle("database");
		NAME = res.getString("MOBILE_CLAZZ").trim();
	}
	public static MobileDao getMobileDao() {
		try {
			return (MobileDao) Class.forName(NAME).newInstance();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}
	
	
}
