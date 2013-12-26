package com.vedantu.ei.responses.pojos;

import org.json.JSONException;
import org.json.JSONObject;

import com.vedantu.ei.commons.JSONAware;

public class ClassInfo implements JSONAware {

	public String classCode;
	public long expiry;

	public static ClassInfo construct(String classCode, long expiry) {
		ClassInfo classInfo = new ClassInfo();
		classInfo.classCode = classCode;
		classInfo.expiry = expiry;
		return classInfo;
	}

	public void fromJSON(JSONObject json) throws JSONException {
		this.classCode = json.getString(KEY_CLASS_CODE);
		this.expiry = json.getLong(KEY_EXPIRY);
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put(KEY_CLASS_CODE, this.classCode);
			json.put(KEY_EXPIRY, this.expiry);
		} catch (JSONException e) {
			// swallow
		}
		return json;
	}

	private static final String KEY_CLASS_CODE = "classCode";
	private static final String KEY_EXPIRY = "expiry";
}
