package com.vedantu.ei.responses.pojos;

import org.json.JSONException;
import org.json.JSONObject;

import com.vedantu.ei.commons.JSONAware;
import com.vedantu.ei.responses.IResponseValidator;
import com.vedantu.ei.utils.StringUtils;

public class ClassInfo implements JSONAware, IResponseValidator {

	private String classCode;
	private long expiry;

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public long getExpiry() {
		return expiry;
	}

	public void setExpiry(long expiry) {
		this.expiry = expiry;
	}

	public void validate() throws IllegalArgumentException {
		if (StringUtils.isEmpty(classCode)) {
			throw new IllegalArgumentException(
					"Missing arguments: in ClassInfo -- classCode");
		}
	}

	public void fromJSON(JSONObject json) throws JSONException {
		this.classCode = json.getString(KEY_CLASS_CODE);
		this.expiry = json.getLong(KEY_EXPIRY);
	}

	public JSONObject toJSON() {
		validate();

		JSONObject json = new JSONObject();
		try {
			json.put(KEY_CLASS_CODE, this.classCode);
			json.put(KEY_EXPIRY, this.expiry);
		} catch (JSONException e) {
			// swallow
		}
		return json;
	}

	public String toString() {
		return "ClassInfo [classCode=" + classCode + ", expiry=" + expiry + "]";
	}

	private static final String KEY_CLASS_CODE = "classCode";
	private static final String KEY_EXPIRY = "expiry";
}
