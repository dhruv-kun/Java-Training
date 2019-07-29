package com.visa.prj.entity;

public class Time {
	private int hrs;
	private int min;
	
	public int getHrs() {
		return hrs;
	}

	public void setHrs(int hrs) {
		this.hrs = hrs;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public Time(int hrs, int min) {
		this.hrs = hrs;
		this.min = min;
	}
	
	public static Time addTime(Time t1, Time t2) {
		int min = t1.getMin() + t2.getMin();
		int hrs = t1.getHrs() + t2.getHrs();
		if (min >= 60) {
			min %= 60;
			hrs += 1;
		}
 		return new Time(hrs, min);
	}
	
	public Time addTime(Time t) {
		return Time.addTime(this,  t);
	}
}
