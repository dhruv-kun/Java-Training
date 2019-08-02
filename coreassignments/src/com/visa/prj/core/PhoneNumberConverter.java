package com.visa.prj.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Alpha Phrase to Phone Number Converter
 * 
 * @author banu
 * 
 */
public class PhoneNumberConverter {

	/**
	 * Converts the given alpha phrase to the corresponding phone number.
	 * 
	 * @param input
	 *            Input will be an alpha phrase which represents a phone number.
	 *            The input may contain the spaces and the hyphen (-).
	 * @return Output is the phone number and it retains any space and hyphen
	 *         symbol from the input.
	 */
	public String convertPhoneNumber(String input) {
		List<String> numPad = Arrays.asList(new String[]{"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"});

		Map<String, Integer> numPadMap = new HashMap<>();
		for (int i = 0; i < numPad.size(); i++) {
			numPadMap.put(numPad.get(i), i);
		}

		StringBuilder number = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i))) {
				number.append(input.charAt(i));
				continue;
			} else if (Character.isLetter(input.charAt(i))) {
				for (String key : numPadMap.keySet()) {
					if (key.indexOf(input.charAt(i)) >= 0) {
						number.append(numPadMap.get(key));
						break;
					}
				}
			} else {
				number.append(input.charAt(i));
			}
		}
		return number.toString();
	}
}
