package com.vedantu.ei.responses;

import com.vedantu.ei.results.EnrollResult;

public class EnrollResponse extends AbstractVedantuResponse {

	public EnrollResponse(String errorCode, String errorMessage,
			EnrollResult result) {
		super(errorCode, errorMessage, result);
	}

}
