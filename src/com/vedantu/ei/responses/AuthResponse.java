package com.vedantu.ei.responses;

import com.vedantu.ei.commons.enums.VedantuErrorCode;
import com.vedantu.ei.results.AuthResult;

public class AuthResponse extends AbstractVedantuResponse {

	public AuthResponse(VedantuErrorCode errorCode, String errorMessage,
			AuthResult result) {
		super(errorCode, errorMessage, result);
	}

}
