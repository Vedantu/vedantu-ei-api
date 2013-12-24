package com.vedantu.ei.responses;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.vedantu.ei.commons.enums.VedantuErrorCode;
import com.vedantu.ei.exceptions.VedantuException;

public class ErrorResponse extends AbstractVedantuResponse {

	public ErrorResponse(VedantuException e) {
		super(e.errorCode, e.getMessage(), NO_RESULT);
	}

	public ErrorResponse(Throwable t) {
		super(VedantuErrorCode.UNHANDLED_ERROR, null, NO_RESULT);

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);

		errorMessage = sw.toString();
	}

}
