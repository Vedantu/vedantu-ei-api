package com.vedantu.ei.requests;

import org.json.JSONException;
import org.json.JSONObject;

public class AuthRequest extends AbstractVedantuRequest {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void fromJSON(JSONObject json) throws JSONException {
		this.username = json.getString(KEY_USERNAME);
		this.password = json.getString(KEY_PASSWORD);
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put(KEY_USERNAME, this.username);
			json.put(KEY_PASSWORD, this.password);
		} catch (JSONException e) {
			// swallow
		}
		return json;
	}

	private static final String KEY_USERNAME = "username";
	private static final String KEY_PASSWORD = "password";
}
