package com.vedantu.ei.commons.enums;

public final class Role {

	/* enum Role */

	public static final String STUDENT = "STUDENT";
	public static final String TEACHER = "TEACHER";
	public static final String ADMIN = "ADMIN";

	public static String valueOf(String key) {
		if (TEACHER.equalsIgnoreCase(key)) {
			return TEACHER;
		} else if (ADMIN.equalsIgnoreCase(key)) {
			return ADMIN;
		}
		return STUDENT;
	}

}
