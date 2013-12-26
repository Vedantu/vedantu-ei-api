package com.vedantu.ei.exceptions;

public class VedantuException extends Exception {

	private static final long serialVersionUID = 1L;

	/* enum VedantuErrorCode */
	public final String errorCode;

	public VedantuException(String errorCode) {

		this(errorCode, null, null);
	}

	public VedantuException(String errorCode, String message) {

		this(errorCode, message, null);
	}

	public VedantuException(String errorCode, Throwable t) {

		this(errorCode, null, t);
	}

	public VedantuException(String errorCode, String message, Throwable t) {

		super(message, t);
		this.errorCode = errorCode;
	}

	public String toString() {

		return "VedantuException [errorCode=" + errorCode + ", toString()="
				+ super.toString() + "]";
	}

}
