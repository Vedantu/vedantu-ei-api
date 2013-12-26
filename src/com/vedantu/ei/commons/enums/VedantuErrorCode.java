package com.vedantu.ei.commons.enums;

public final class VedantuErrorCode implements IVedantuEnum {

	/* enum VedantuErrorCode */

	public static final String UNHANDLED_ERROR = "UNHANDLED_ERROR";
	public static final String AUTHENTICATION_FAILED = "AUTHENTICATION_FAILED";
	public static final String INVALID_TEST_CODE = "INVALID_TEST_CODE";
	public static final String INVALID_USER_ID = "INVALID_USER_ID";
	public static final String INVALID_CONTENT_TYPE = "INVALID_CONTENT_TYPE";
	public static final String UPLOAD_FAILED = "UPLOAD_FAILED";

	public String valueOf(String key) {
		return null == key ? null : key.toUpperCase();
	}

}
