package com.vedantu.ei.managers.sample;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.vedantu.ei.commons.enums.VedantuErrorCode;
import com.vedantu.ei.managers.api.IUploadManager;
import com.vedantu.ei.requests.UploadTestAttemptsRequest;
import com.vedantu.ei.requests.pojos.Attempt;
import com.vedantu.ei.responses.UploadTestAttemptsResponse;
import com.vedantu.ei.responses.pojos.FailedAttemptUploadInfo;
import com.vedantu.ei.results.UploadTestAttemptsResult;

public class SampleUploadManager implements IUploadManager {

	@Override
	public UploadTestAttemptsResponse uploadTestAttempts(
			UploadTestAttemptsRequest request) throws InvocationTargetException {

		UploadTestAttemptsResult result = new UploadTestAttemptsResult();

		Set<String> validTestCodes = new HashSet<String>(
				Arrays.asList(new String[] { "TEST-01", "TEST-02", "TEST-03", }));
		boolean uploadFailed = false;

		for (Attempt attempt : request.getAttempts()) {

			if (!attempt.getUserId().equals("654321abc")) {
				uploadFailed = true;
				result.addFailedAttemptUploadInfo(new FailedAttemptUploadInfo(
						attempt.getAttemptId(),
						VedantuErrorCode.INVALID_USER_ID));
				continue;
			}

			if (!validTestCodes.contains(attempt.getCode())) {
				uploadFailed = true;
				result.addFailedAttemptUploadInfo(new FailedAttemptUploadInfo(
						attempt.getAttemptId(),
						VedantuErrorCode.INVALID_TEST_CODE));
				continue;
			}
		}

		VedantuErrorCode errorCode = null;
		String errorMessage = null;

		if (uploadFailed) {
			errorCode = VedantuErrorCode.UPLOAD_FAILED;
			errorMessage = "some attempts could not be uploaded";
		}

		return new UploadTestAttemptsResponse(errorCode, errorMessage, result);
	}
}
