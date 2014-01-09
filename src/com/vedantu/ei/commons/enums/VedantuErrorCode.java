package com.vedantu.ei.commons.enums;

public final class VedantuErrorCode {

	/* enum VedantuErrorCode */

	public static final String UNHANDLED_ERROR = "UNHANDLED_ERROR";
	public static final String AUTHENTICATION_FAILED = "AUTHENTICATION_FAILED";
	public static final String INVALID_TEST_CODE = "INVALID_TEST_CODE";
	public static final String INVALID_USER_ID = "INVALID_USER_ID";
	public static final String INVALID_CONTENT_TYPE = "INVALID_CONTENT_TYPE";
	public static final String UPLOAD_FAILED = "UPLOAD_FAILED";
	public static final String USER_ALREADY_EXISTS = "USER_ALREADY_EXISTS";
	public static final String MISSING_PARAMETERS = "MISSING_PARAMETERS";

	public static String valueOf(String key) {
		return null == key ? null : key.toUpperCase();
	}

}
