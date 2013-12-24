package com.vedantu.ei.managers.api;

import java.lang.reflect.InvocationTargetException;

import com.vedantu.ei.requests.UploadTestAttemptsRequest;
import com.vedantu.ei.responses.UploadTestAttemptsResponse;

public interface IUploadManager extends IManager {

	UploadTestAttemptsResponse uploadTestAttempts(UploadTestAttemptsRequest request)
			throws InvocationTargetException;
}
