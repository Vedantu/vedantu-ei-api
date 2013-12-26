package com.vedantu.ei.results;

import org.json.JSONException;
import org.json.JSONObject;

public final class BooleanResult extends AbstractVedantuResult {

	private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void validate() throws IllegalArgumentException {
		// Nothing to do
	}

	public void fromJSON(JSONObject json) throws JSONException {
		this.success = json.getBoolean(KEY_SUCCESS);
	}

	public JSONObject toJSON() {
		// No need to call -- validate();

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
