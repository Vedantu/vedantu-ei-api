package com.vedantu.ei.responses.pojos;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.vedantu.ei.commons.JSONAware;
import com.vedantu.ei.responses.IResponseValidator;
import com.vedantu.ei.utils.CollectionUtils;
import com.vedantu.ei.utils.StringUtils;

public class FailedAttemptUploadInfo implements JSONAware, IResponseValidator {

	private String attemptId;
	/* enum VedantuErrorCode */
	private String errorCode;

	public String getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(String attemptId) {
		this.attemptId = attemptId;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void validate() throws IllegalArgumentException {
		List missingArgs = new ArrayList();
		if (StringUtils.isEmpty(attemptId)) {
			missingArgs.add(KEY_ATTEMPT_ID);
		}
		if (StringUtils.isEmpty(errorCode)) {
			missingArgs.add(KEY_ERROR_CODE);
		}
		if (!CollectionUtils.isEmpty(missingArgs)) {
			throw new IllegalArgumentException(
					"Missing arguments: in FailedAttemptUploadInfo -- "
							+ missingArgs);
		}
	}

	public void fromJSON(JSONObject json) throws JSONException {
		this.attemptId = json.getString(KEY_ATTEMPT_ID);
		this.errorCode = json.getString(KEY_ERROR_CODE);
	}

	public JSONObject toJSON() {
		validate();

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
