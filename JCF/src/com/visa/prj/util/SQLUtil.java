package com.visa.prj.util;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import com.visa.prj.annotations.Column;
import com.visa.prj.annotations.Table;

public class SQLUtil {
	
	public static String generateCreateSQL(Class<?> clazz) {
		
		/*
		 * String is immutable and when we append string at the end
		 * it builds a new Object which is expensive.
		 * StringBuilder and StringBuffer are mutable and appending 
		 * string is cheaper than simply adding to String
		 * 
		 * StringBuffer is thread-safe
		 * StringBuilder is NOT thread-safe
		 * 
		 * On object level use StringBuffer
		 * On method level use StringBuilder
		 */
		
		StringBuilder builder = new StringBuilder();
		Table t = clazz.getAnnotation(Table.class);
		
		if (t != null) {
			builder.append("create table");
			builder.append(" ");
			builder.append(t.name());
			builder.append("(");
			Method[] methods = clazz.getDeclaredMethods();
			
			for (Method m: methods) {
				if (m.getName().startsWith("get")) {
					Column c = m.getAnnotation(Column.class);
					if (c != null) {
						builder.append(c.name());
						builder.append(" ");
						builder.append(c.type());
						builder.append(", ");
					}
				}
			}
		}
		
		builder.setCharAt(builder.lastIndexOf(","), (')'));
		return builder.toString();
	}
	
	public static String generateInsertSQL(Object obj) {
		StringBuilder builder = new StringBuilder();
		StringBuilder typeBuilder = new StringBuilder();
		
		Table t = obj.getClass().getAnnotation(Table.class);
		if (t != null) {
			
			typeBuilder.append("insert into ");
			typeBuilder.append(t.name());
			typeBuilder.append("(");
			builder.append("values(");
			
			Method[] methods = obj.getClass().getDeclaredMethods();
			
			for (Method m: methods) {
				Column c = m.getAnnotation(Column.class);
				if (c != null && m.getName().startsWith("get")) {
					try {
						typeBuilder.append(c.name());
						builder.append(c.type());
					} catch (Exception e) {
						e.printStackTrace();
					}
					typeBuilder.append(", ");
					builder.append(", ");
				}
			}
			typeBuilder.setCharAt(typeBuilder.lastIndexOf(","), (')'));
			builder.setCharAt(builder.lastIndexOf(","), (')'));
			typeBuilder.append(builder.toString());
			typeBuilder.append(";");
			
		}
		
		return typeBuilder.toString();
	}
	
}


