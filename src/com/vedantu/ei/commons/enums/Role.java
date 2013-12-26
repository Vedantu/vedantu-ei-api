package com.vedantu.ei.commons.enums;

public final class Role implements IVedantuEnum {

	/* enum Role */

	public static final String STUDENT = "STUDENT";
	public static final String TEACHER = "TEACHER";
	public static final String ADMIN = "ADMIN";

	public String valueOf(String key) {
		if (TEACHER.equalsIgnoreCase(key)) {
			return TEACHER;
		} else if (ADMIN.equalsIgnoreCase(key)) {
			return ADMIN;
		}
		return STUDENT;
	}

}
