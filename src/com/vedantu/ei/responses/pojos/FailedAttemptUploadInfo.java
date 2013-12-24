package com.vedantu.ei.responses.pojos;

import java.lang.reflect.InvocationTargetException;

import com.vedantu.ei.commons.enums.VedantuErrorCode;
import com.vedantu.ei.utils.StringUtils;

public class FailedAttemptUploadInfo {

	private String attemptId;
	private VedantuErrorCode errorCode;

	public FailedAttemptUploadInfo(String attemptId, VedantuErrorCode errorCode)
			throws InvocationTargetException {

		super();
		if (StringUtils.isEmpty(attemptId) || null == errorCode) {
			throw new InvocationTargetException(new Throwable(
					"Can not instantiate FailedAttempUploadInfo empty values"));
		}
		this.attemptId = attemptId;
		this.errorCode = errorCode;
	}

	public String getAttemptId() {

		return attemptId;
	}

	public VedantuErrorCode getErrorCode() {

		return errorCode;
	}

}
