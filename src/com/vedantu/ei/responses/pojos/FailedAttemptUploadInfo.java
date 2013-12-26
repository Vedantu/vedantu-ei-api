package com.vedantu.ei.responses.pojos;

import org.json.JSONException;
import org.json.JSONObject;

import com.vedantu.ei.commons.JSONAware;

public class FailedAttemptUploadInfo implements JSONAware {

	public String attemptId;
	/* enum VedantuErrorCode */
	public String errorCode;

	public static FailedAttemptUploadInfo construct(String attemptId,
			String errorCode) {
		FailedAttemptUploadInfo failedAttemptUploadInfo = new FailedAttemptUploadInfo();
		failedAttemptUploadInfo.attemptId = attemptId;
		failedAttemptUploadInfo.errorCode = errorCode;
		return failedAttemptUploadInfo;
	}

	public void fromJSON(JSONObject json) throws JSONException {
		this.attemptId = json.getString(KEY_ATTEMPT_ID);
		this.errorCode = json.getString(KEY_ERROR_CODE);
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put(KEY_ATTEMPT_ID, this.attemptId);
			json.put(KEY_ERROR_CODE, this.errorCode);
		} catch (JSONException e) {
			// swallow
		}
		return json;
	}

	private static final String KEY_ATTEMPT_ID = "attemptId";
	private static final String KEY_ERROR_CODE = "errorCode";

}
