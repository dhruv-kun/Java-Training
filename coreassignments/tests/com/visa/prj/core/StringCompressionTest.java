package com.visa.prj.core;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCompressionTest {

	@Test
	public void UTC03_01() {

		String input = "aAbcccccaaA";
		String expected = "a2b1c5a3";
		StringCompression object = new StringCompression();
		String actual = object.getCompressedString(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UTC03_02() {

		String input = "BBBBbbb";
		String expected = "b7";
		StringCompression object = new StringCompression();
		String actual = object.getCompressedString(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UTC03_03() {

		String input = "ZANCKKKKPpppp";
		String expected = "z1a1n1c1k4p5";
		StringCompression object = new StringCompression();
		String actual = object.getCompressedString(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UTC03_04() {

		String input = "abCcc";
		String expected = "abccc";
		StringCompression object = new StringCompression();
		String actual = object.getCompressedString(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UTC03_05() {

		String input = "A";
		String expected = "a";
		StringCompression object = new StringCompression();
		String actual = object.getCompressedString(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UTC03_06() {

		String input = "ZzaA";
		String expected = "zzaa";
		StringCompression object = new StringCompression();
		String actual = object.getCompressedString(input);
		assertEquals(expected, actual);
	}

}
