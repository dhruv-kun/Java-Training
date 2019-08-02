package com.visa.prj.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneClient {

	public static void main(String[] args) {
		List<String> numPad = Arrays.asList(new String[]{"", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"});
		
		Map<String, Integer> numPadMap = new HashMap<>();
		for (int i = 0; i < numPad.size(); i++) {
			numPadMap.put(numPad.get(i), i);
		}
		
		List<String> numbers = Arrays.asList(new String[]{
			"342-CARS", "92834 OIQUO"
		});
		StringBuilder number = new StringBuilder();
		for (String num: numbers) {
			for (int i = 0; i < num.length(); i++) {
				if (Character.isDigit(num.charAt(i))) {
					number.append(num.charAt(i));
					continue;
				}
				else if (Character.isLetter(num.charAt(i))) {
					for (String key: numPadMap.keySet()) {
						if (key.))
					}
//				}
			}
		}

	}

}
