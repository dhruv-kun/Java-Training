package com.visa.prj.core;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.visa.prj.entity.Article;

public class ReflectionClient {

	
	public static String generateXML(Object obj) {
		String className = obj.getClass().getSimpleName();
		
		StringBuilder builder = new StringBuilder();
		builder.append("<");
		builder.append(className);
		builder.append(">\n");
		Map<String, String> map = new HashMap<>();
		Method[] methods = obj.getClass().getDeclaredMethods();
		
		for (Method m: methods) {
			try {
				String mName = m.getName();
				if (mName.startsWith("get")) {
					String tag = mName.substring(mName.indexOf("get") + 3).toLowerCase();
					String value = m.invoke(obj).toString();
					map.put(tag, value);	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (String key: map.keySet()) {
			builder.append("<");
			builder.append(key);
			builder.append(">");
			builder.append(map.get(key));
			builder.append("</");
			builder.append(key);
			builder.append(">\n");
		}
		builder.append("</");
		builder.append(className);
		builder.append(">");
		
		return builder.toString();
	}
	public static void main(String[] args) {
		Article a = new Article("NoDBA",561,"bliki",Arrays.asList("nosql","people","orm"));
		String XML = generateXML(a);
		System.out.println(XML);

	}

}
