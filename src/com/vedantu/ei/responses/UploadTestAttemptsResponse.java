package com.vedantu.ei.responses;

import com.vedantu.ei.results.UploadTestAttemptsResult;

public class UploadTestAttemptsResponse extends AbstractVedantuResponse {

	public UploadTestAttemptsResponse(String errorCode, String errorMessage,
			UploadTestAttemptsResult result) {
		super(errorCode, errorMessage, result);
	}

}
