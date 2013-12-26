package com.vedantu.ei.managers.sample;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.vedantu.ei.commons.enums.VedantuErrorCode;
import com.vedantu.ei.managers.api.IUploadManager;
import com.vedantu.ei.requests.UploadTestAttemptsRequest;
import com.vedantu.ei.requests.pojos.Attempt;
import com.vedantu.ei.responses.UploadTestAttemptsResponse;
import com.vedantu.ei.responses.pojos.FailedAttemptUploadInfo;
import com.vedantu.ei.results.UploadTestAttemptsResult;

public class SampleUploadManager implements IUploadManager {

	public UploadTestAttemptsResponse uploadTestAttempts(
			UploadTestAttemptsRequest request) throws InvocationTargetException {

		UploadTestAttemptsResult result = new UploadTestAttemptsResult();

		/* <String> */
		Set validTestCodes = new HashSet(Arrays.asList(new String[] {
				"TEST-01", "TEST-02", "TEST-03", }));
		boolean uploadFailed = false;

		Iterator attemptsIterator = request.getAttempts().iterator();

		while (attemptsIterator.hasNext()) {

			Attempt attempt = (Attempt) attemptsIterator.next();

			if (!attempt.getUserId().equals("654321abc")) {
				uploadFailed = true;
				result.addFailedAttemptUploadInfo(FailedAttemptUploadInfo
						.construct(attempt.getAttemptId(),
								VedantuErrorCode.INVALID_USER_ID));
				continue;
			}

			if (!validTestCodes.contains(attempt.getCode())) {
				uploadFailed = true;
				result.addFailedAttemptUploadInfo(FailedAttemptUploadInfo
						.construct(attempt.getAttemptId(),
								VedantuErrorCode.INVALID_TEST_CODE));
				continue;
			}
		}

		String errorCode = null;
		String errorMessage = null;

		if (uploadFailed) {
			errorCode = VedantuErrorCode.UPLOAD_FAILED;
			errorMessage = "some attempts could not be uploaded";
		}

		return new UploadTestAttemptsResponse(errorCode, errorMessage, result);
	}
}
