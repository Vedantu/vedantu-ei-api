package com.vedantu.ei.responses;

import com.vedantu.ei.results.RegResult;

public class RegResponse extends AbstractVedantuResponse {

	public RegResponse(String errorCode, String errorMessage,
			RegResult result) {
		super(errorCode, errorMessage, result);
	}

}
