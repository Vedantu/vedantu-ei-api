package com.vedantu.ei.commons.enums;

public final class Gender {

	/* enum Gender */

	public static final String UNKNOWN = "UNKNOWN";
	public static final String MALE = "MALE";
	public static final String FEMALE = "FEMALE";

	public static String valueOf(String key) {
		if (MALE.equalsIgnoreCase(key)) {
			return MALE;
		} else if (FEMALE.equalsIgnoreCase(key)) {
			return FEMALE;
		}
		return UNKNOWN;
	}

}
