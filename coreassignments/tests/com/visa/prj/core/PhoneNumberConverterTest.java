package com.visa.prj.core;


import static org.junit.Assert.*;


import org.junit.Test;

public class PhoneNumberConverterTest {


	@Test
	public void UTC02_01() {
		String input = "1800COMPUTE";
		String expected = "18002667883";
		PhoneNumberConverter object = new PhoneNumberConverter();
		String actual = object.convertPhoneNumber(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UTC02_02() {
		String input = "9HELLO1234";
		String expected = "9435561234";
		PhoneNumberConverter object = new PhoneNumberConverter();
		String actual = object.convertPhoneNumber(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UTC02_03() {
		String input = "MIND9999IT";
		String expected = "6463999948";
		PhoneNumberConverter object = new PhoneNumberConverter();
		String actual = object.convertPhoneNumber(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UTC02_04() {
		String input = "1 800 GOFONTS";
		String expected = "1 800 4636687";
		PhoneNumberConverter object = new PhoneNumberConverter();
		String actual = object.convertPhoneNumber(input);
		assertEquals(expected, actual);
	}

	@Test
	public void UTC02_05() {
		String input = "1-800-MY-APPLE";
		String expected = "1-800-69-27753";
		PhoneNumberConverter object = new PhoneNumberConverter();
		String actual = object.convertPhoneNumber(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UTC02_06() {
		String input = "9-HELLO-1234";
		String expected = "9-43556-1234";
		PhoneNumberConverter object = new PhoneNumberConverter();
		String actual = object.convertPhoneNumber(input);
		assertEquals(expected, actual);
	}
}
