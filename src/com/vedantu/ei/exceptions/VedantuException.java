package com.vedantu.ei.exceptions;

import com.vedantu.ei.commons.enums.VedantuErrorCode;

public class VedantuException extends Exception {

	private static final long serialVersionUID = 1L;

	public final VedantuErrorCode errorCode;

	public VedantuException(VedantuErrorCode errorCode) {

		this(errorCode, null, null);
	}

	public VedantuException(VedantuErrorCode errorCode, String message) {

		this(errorCode, message, null);
	}

	public VedantuException(VedantuErrorCode errorCode, Throwable t) {

		this(errorCode, null, t);
	}

	public VedantuException(VedantuErrorCode errorCode, String message,
			Throwable t) {

		super(message, t);
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {

		return "VedantuException [errorCode=" + errorCode + ", toString()="
				+ super.toString() + "]";
	}

}
