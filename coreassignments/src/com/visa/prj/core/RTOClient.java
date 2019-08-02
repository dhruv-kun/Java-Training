package com.visa.prj.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RTOClient {

	public static void main(String[] args) {
		Map<String, String> rtoCodes = new HashMap<>();
		rtoCodes.put("KA-02", "rajininagar");
		rtoCodes.put("KA-01", "koramagala");
		rtoCodes.put("KA-03", "indiranagar");
		rtoCodes.put("KA-04", "yeshwanthpur");
		rtoCodes.put("KA-55", "mysore east");
		rtoCodes.put("KA-56", "basavakalyan");
		
		List<String> regNum = new ArrayList<String>();
		regNum.add("KA-55-AB-4555");
		regNum.add("KA-01-EF-4444");
		regNum.add("KA-56-200");
		regNum.add("KA-04-AB-900");
		
		Collections.sort(regNum, (r1, r2) -> {
			String t1 = r1.substring(0, r1.indexOf('-', r1.indexOf('-') + 1));
			String t2 = r2.substring(0, r2.indexOf('-', r2.indexOf('-') + 1));
			if (t1.equals(t2))
				return r1.compareTo(r2);
			return rtoCodes.get(t1).compareTo(rtoCodes.get(t2));
		});
		
		for (String s: regNum)
			System.out.println(s);
	}

}
