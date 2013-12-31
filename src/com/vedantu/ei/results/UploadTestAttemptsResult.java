package com.vedantu.ei.results;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.vedantu.ei.responses.pojos.FailedAttemptUploadInfo;
import com.vedantu.ei.utils.JSONUtils;

public class UploadTestAttemptsResult extends AbstractVedantuResult {

	/* <FailedAttemptUploadInfo> */
	private List failedAttempts = new ArrayList();

	public List getFailedAttempts() {
		return failedAttempts;
	}

	public void setFailedAttempts(List failedAttempts) {
		this.failedAttempts = failedAttempts;
	}

	public void addFailedAttemptUploadInfo(
			FailedAttemptUploadInfo attemptUploadInfo) {
		failedAttempts.add(attemptUploadInfo);
	}

	public void validate() throws IllegalArgumentException {

		if (null == failedAttempts) {
			throw new IllegalArgumentException(
					"Missing arguments: in UploadTestAttemptsResult -- failedAttempts can not be null");
		}
	}

	public void fromJSON(JSONObject json) throws JSONException {
		JSONArray failedAttemptsJSONArray = json
				.getJSONArray(KEY_FAILED_ATTEMPTS);
		for (int i = 0; i < failedAttemptsJSONArray.length(); i++) {
			JSONObject failedAttemptJSON = (JSONObject) failedAttemptsJSONArray
					.get(i);
			FailedAttemptUploadInfo failedAttemptUploadInfo = new FailedAttemptUploadInfo();
			failedAttemptUploadInfo.fromJSON(failedAttemptJSON);
			this.failedAttempts.add(failedAttemptUploadInfo);
		}
	}

	public JSONObject toJSON() {
		validate();

		JSONObject json = new JSONObject();
		try {
			json.put(KEY_FAILED_ATTEMPTS,
					JSONUtils.toJSONArray(this.failedAttempts));
		} catch (JSONException e) {
			// swallow
		}
		return json;
	}

	public String toString() {
		return "{failedAttempts:" + failedAttempts + "}";
	}

	private static final String KEY_FAILED_ATTEMPTS = "failedAttempts";
}
