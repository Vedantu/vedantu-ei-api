package com.vedantu.ei.requests;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.vedantu.ei.requests.pojos.Attempt;
import com.vedantu.ei.utils.JSONUtils;

public class UploadTestAttemptsRequest extends AbstractVedantuRequest {

	private String uploadId;
	/* <Attempt> */
	private List attempts = new ArrayList();

	public String getUploadId() {

		return uploadId;
	}

	public void setUploadId(String uploadId) {

		this.uploadId = uploadId;
	}

	public List getAttempts() {

		return attempts;
	}

	public void setAttempts(List attempts) {

		this.attempts = attempts;
	}

	public void addAttempts(Attempt[] attempts) {

		if (attempts != null) {
			for (int i = 0; i < attempts.length; i++) {
				this.attempts.add(attempts[i]);
			}
		}
	}

	public void addAttempt(Attempt attempt) {

		this.attempts.add(attempt);
	}

	public void fromJSON(JSONObject json) throws JSONException {
		this.uploadId = json.getString(KEY_UPLOAD_ID);

		JSONArray attemptsJSONArray = json.getJSONArray(KEY_ATTEMPTS);
		for (int i = 0; i < attemptsJSONArray.length(); i++) {
			JSONObject attemptJSON = (JSONObject) attemptsJSONArray.get(i);
			Attempt attempt = new Attempt();
			attempt.fromJSON(attemptJSON);
			this.attempts.add(attempt);
		}
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put(KEY_UPLOAD_ID, this.uploadId);
			json.put(KEY_ATTEMPTS, JSONUtils.toJSONArray(this.attempts));
		} catch (JSONException e) {
			// swallow
		}
		return json;
	}

	private static final String KEY_UPLOAD_ID = "uploadId";
	private static final String KEY_ATTEMPTS = "attempts";
}
