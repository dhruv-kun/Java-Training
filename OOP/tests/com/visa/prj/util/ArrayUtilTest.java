package com.visa.prj.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void testGetSum() {
		int[] elems = {5, 6, 4};
		assertEquals(15, ArrayUtil.getSum(elems));
	
		int[] data = {1, 0, -1};
		assertEquals(0, ArrayUtil.getSum(data));
	}
	

	@Test
	public void testGetCount() {
		int[] data = {53, 67, 3, 73, 21, 67};
		assertEquals(2, ArrayUtil.getCount(data, 67));
	}

	@Test
	public void testSort() {
		int[] data = {53, 67, 3, 73, 21, 67};
		ArrayUtil.sort(data);
		int[] expected = {3, 21, 53, 67, 67, 73};
		assertArrayEquals(expected, data);
	}

}
