package com.vedantu.ei.results;

import org.json.JSONException;
import org.json.JSONObject;

public final class BooleanResult extends AbstractVedantuResult {

	public boolean success;

	public void fromJSON(JSONObject json) throws JSONException {
		this.success = json.getBoolean(KEY_SUCCESS);
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put(KEY_SUCCESS, this.success);
		} catch (JSONException e) {
			// swallow
		}
		return json;
	}

	private static final String KEY_SUCCESS = "success";
}
