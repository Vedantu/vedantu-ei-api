package com.vedantu.ei.results;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.vedantu.ei.utils.CollectionUtils;
import com.vedantu.ei.utils.JSONUtils;
import com.vedantu.ei.utils.StringUtils;

public class RegResult extends AbstractVedantuResult {

	private String userId;
	private String memberId;
	/* <String> */
	private List missingParameters = new ArrayList();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public List getMissingParameters() {
		return missingParameters;
	}

	public void setMissingParameters(List missingParameters) {
		this.missingParameters = missingParameters;
	}

	public void addMissingParameter(String missingParameter) {
		this.missingParameters.add(missingParameter);
	}

	public void validate() throws IllegalArgumentException {
		if (StringUtils.isEmpty(userId)
				&& CollectionUtils.isEmpty(missingParameters)) {
			throw new IllegalArgumentException(
					"Missing arguments: in RegResult -- required userId or missingParameters");
		}
	}

	public void fromJSON(JSONObject json) throws JSONException {
		this.userId = json.getString(KEY_USER_ID);
		this.memberId = JSONUtils.getString(json, KEY_MEMBER_ID, userId);
		JSONArray missingParametersJSONArray = JSONUtils.getJSONArray(json,
				KEY_MISSING_PARAMETERS, new JSONArray());
		for (int i = 0; i < missingParametersJSONArray.length(); i++) {
			String missingParameter = missingParametersJSONArray.getString(i);
			this.missingParameters.add(missingParameter);
		}
	}

	public JSONObject toJSON() {
		validate();

		JSONObject json = new JSONObject();
		try {
			json.put(KEY_USER_ID, this.userId);
			json.put(KEY_MEMBER_ID, this.memberId);
			json.put(KEY_MISSING_PARAMETERS, new JSONArray(
					this.missingParameters));
		} catch (JSONException e) {
			// swallow
		}
		return json;
	}

	public String toString() {
		return "{userId:" + userId + ", memberId:" + memberId
				+ ", missingParameters:" + missingParameters + "}";
	}

	private static final String KEY_USER_ID = "userId";
	private static final String KEY_MEMBER_ID = "memberId";
	private static final String KEY_MISSING_PARAMETERS = "missingParameters";

}
