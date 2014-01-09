package com.vedantu.ei.requests;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.vedantu.ei.commons.enums.Gender;
import com.vedantu.ei.utils.JSONUtils;

public class RegRequest extends AbstractVedantuRequest {

	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	/* enum Gender */
	private String gender;
	/* enum Role */
	private String role;
	/* <String, Object (cast this to String)> */
	private Map additionalInfo = new HashMap();

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Map getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Map additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public void addAdditionalInfo(String key, String value) {
		this.additionalInfo.put(key, value);
	}

	public void fromJSON(JSONObject json) throws JSONException {
		this.username = json.getString(KEY_USERNAME);
		this.password = json.getString(KEY_PASSWORD);
		this.email = JSONUtils.getString(json, KEY_EMAIL, null);
		this.firstName = json.getString(KEY_FIRST_NAME);
		this.lastName = JSONUtils.getString(json, KEY_LAST_NAME, null);
		this.gender = Gender.valueOf(JSONUtils
				.getString(json, KEY_GENDER, null));
		this.role = Gender.valueOf(JSONUtils.getString(json, KEY_ROLE, null));
		if (json.has(KEY_ADDITIONAL_INFO)) {
			this.additionalInfo = JSONUtils.toMap(json, KEY_ADDITIONAL_INFO);
		}
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put(KEY_USERNAME, this.username);
			json.put(KEY_PASSWORD, this.password);
			json.put(KEY_EMAIL, this.email);
			json.put(KEY_FIRST_NAME, this.firstName);
			json.put(KEY_LAST_NAME, this.lastName);
			json.put(KEY_GENDER, this.gender);
			json.put(KEY_ROLE, this.role);
			json.put(KEY_ADDITIONAL_INFO, this.additionalInfo);
		} catch (JSONException e) {
			// swallow
		}
		return json;
	}

	public String toString() {
		return "{username:" + username + "email:" + email + ", firstName:"
				+ firstName + ", lastName:" + lastName + ", gender:" + gender
				+ ", role:" + role + ", additionalInfo:" + additionalInfo + "}";
	}

	public static final String KEY_USERNAME = "username";
	public static final String KEY_PASSWORD = "password";
	public static final String KEY_EMAIL = "email";
	public static final String KEY_FIRST_NAME = "firstName";
	public static final String KEY_LAST_NAME = "lastName";
	public static final String KEY_GENDER = "gender";
	public static final String KEY_ROLE = "role";
	public static final String KEY_ADDITIONAL_INFO = "additionalInfo";
}
