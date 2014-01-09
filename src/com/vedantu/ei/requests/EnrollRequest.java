package com.vedantu.ei.requests;

import org.json.JSONException;
import org.json.JSONObject;

public class EnrollRequest extends AbstractVedantuRequest {

	private String userId;
	private String classCode;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public void fromJSON(JSONObject json) throws JSONException {
		this.userId = json.getString(KEY_USER_ID);
		this.classCode = json.getString(KEY_CLASS_CODE);
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put(KEY_USER_ID, this.userId);
			json.put(KEY_CLASS_CODE, this.classCode);
		} catch (JSONException e) {
			// swallow
		}
		return json;
	}

	public String toString() {
		return "{userId:" + userId + ", classCode:" + classCode + "}";
	}

	private static final String KEY_USER_ID = "userId";
	private static final String KEY_CLASS_CODE = "classCode";

}
