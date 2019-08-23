package com.visa.prj.web;

import java.beans.PropertyEditorSupport;

import com.visa.prj.entity.Address;

public class AddressPropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] str = text.split(",");
		Address addr = new Address();
		addr.setHouseNo(Integer.parseInt(str[0]));
		addr.setStreet(str[1]);
		addr.setCity(str[2]);
		addr.setZipcode(str[3]);
		
		setValue(addr); // assign it to @RequestParam/@ModelAttribute binding
	}
	
	@Override
	public String getAsText() {
		return super.getAsText();
	}
	
}
