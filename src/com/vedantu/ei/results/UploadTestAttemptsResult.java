package com.vedantu.ei.results;

import java.util.ArrayList;
import java.util.List;

import com.vedantu.ei.responses.pojos.FailedAttemptUploadInfo;

public class UploadTestAttemptsResult extends AbstractVedantuResult {

	private List<FailedAttemptUploadInfo> failedAttempts = new ArrayList<FailedAttemptUploadInfo>();

	public List<FailedAttemptUploadInfo> getFailedAttempts() {
		return failedAttempts;
	}

	public void setFailedAttempts(List<FailedAttemptUploadInfo> failedAttempts) {
		this.failedAttempts = failedAttempts;
	}

	public void addFailedAttemptUploadInfo(
			FailedAttemptUploadInfo... attemptUploadInfos) {

		if (attemptUploadInfos != null) {

			for (int i = 0; i < attemptUploadInfos.length; i++) {
				failedAttempts.add(attemptUploadInfos[i]);
			}
		}
	}

	public void addFailedAttemptUploadInfo(
			FailedAttemptUploadInfo attemptUploadInfo) {

		failedAttempts.add(attemptUploadInfo);
	}
}
