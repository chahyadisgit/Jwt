package com.chahyadis.jwt.model;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

/**
 * BaseModel<br/>
 * .
 * 
 * @author Surya Chahyadi
 * @since March 30th, 2015
 * @version 1.0
 */
public class BaseModel<T> {
	protected Class<T> domainClass;

	@SuppressWarnings("unchecked")
	public BaseModel() {
		this.domainClass = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public String toString() {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("[SOUT " + domainClass.getName() + "] --> ");
		try {
			Field[] fields = domainClass.getDeclaredFields();

			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				strBuffer.append(fields[i].getName()).append(" = ")
						.append(fields[i].get(this)).append(", ");
			}
			strBuffer.deleteCharAt(strBuffer.length() - 2);
		} catch (IllegalAccessException iae) {
			System.out.println(">> error : " + iae);
		}
		return strBuffer.toString();
	}
}
