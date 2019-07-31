package com.visa.prj.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeTest {

	@Test
	public void testStaticAddTime() {
		Time t1 = new Time(4, 30);
		Time t2 = new Time(3, 45);
		
		Time t3 = Time.addTime(t1, t2);
		assertEquals(8, t3.getHrs());
		assertEquals(15, t3.getMin());
	}

	@Test
	public void testAddTime() {
		Time t1 = new Time(4, 30);
		Time t2 = new Time(3, 45);
		
		Time t3 = t1.addTime(t2);
		assertEquals(8, t3.getHrs());
		assertEquals(15, t3.getMin());
	}

}
