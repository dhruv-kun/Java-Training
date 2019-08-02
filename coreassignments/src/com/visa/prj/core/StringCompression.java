package com.visa.prj.core;


/**
 * 3. String Compression
 * 
 * @author banu
 * 
 */
public class StringCompression {

	/**
	 * Let us design a simple compression algorithm where only the frequency of
	 * individual letters is used to compress the data. For e.g., the string
	 * Aabcccccaaa would become a2b1c5a3. The compression logic should be
	 * applied only when the total length of the compressed string is less than
	 * the original string. For the purpose of compression logic, the case
	 * sensitiveness is not considered. For e.g. A and a are considered the
	 * same.
	 * 
	 * @param input
	 *            A String that needs to be compressed is given. Given string
	 *            always contains characters. The string may contain characters
	 *            in upper as well as lower case.
	 * @return Output is the compressed string or the same string if the
	 *         compressed string length is more than or equal to the length of
	 *         the original string. Output contains string in lowercase always.
	 */
	public String getCompressedString(String original) {
		String input = original.toLowerCase();
		char c = input.charAt(0);
		int freq = 1;
		StringBuilder compressedStr = new StringBuilder();
		for (int i = 1; i <= input.length(); i++) {
			if (i == input.length() || c != input.charAt(i)) {
				compressedStr.append(Character.toString(c));
				compressedStr.append(Integer.toString(freq));
				if (i < input.length()) {
					c = input.charAt(i);
					freq = 1;
				}
			} else
				freq += 1;
		}
		if (compressedStr.toString().length() < input.length())
			return compressedStr.toString();
		return input;
	}
}
