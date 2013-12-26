package com.vedantu.ei.responses;

import com.vedantu.ei.results.AuthResult;

public class AuthResponse extends AbstractVedantuResponse {

	public AuthResponse(String errorCode, String errorMessage, AuthResult result) {
		super(errorCode, errorMessage, result);
	}

}
