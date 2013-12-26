package com.vedantu.ei.requests.pojos;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.vedantu.ei.commons.JSONAware;
import com.vedantu.ei.utils.JSONUtils;

public class Attempt implements JSONAware {

	private String code;
	private String userId;
	private String attemptId;
	private float maxScore;
	private float userScore;
	private long attemptStartTime;
	private long attemptEndTime;
	/* <Answer> */
	private List answers = new ArrayList();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(String attemptId) {
		this.attemptId = attemptId;
	}

	public float getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(float maxScore) {
		this.maxScore = maxScore;
	}

	public float getUserScore() {
		return userScore;
	}

	public void setUserScore(float userScore) {
		this.userScore = userScore;
	}

	public long getAttemptStartTime() {
		return attemptStartTime;
	}

	public void setAttemptStartTime(long attemptStartTime) {
		this.attemptStartTime = attemptStartTime;
	}

	public long getAttemptEndTime() {
		return attemptEndTime;
	}

	public void setAttemptEndTime(long attemptEndTime) {
		this.attemptEndTime = attemptEndTime;
	}

	public List getAnswers() {
		return answers;
	}

	public void setAnswers(List answers) {
		this.answers = answers;
	}

	public void addAnswer(Answer answer) {
		this.answers.add(answer);
	}

	public void fromJSON(JSONObject json) throws JSONException {
		this.code = json.getString(KEY_CODE);
		this.userId = json.getString(KEY_USER_ID);
		this.attemptId = json.getString(KEY_ATTEMPT_ID);
		this.maxScore = (float) json.getDouble(KEY_MAX_SCORE);
		this.userScore = (float) json.getDouble(KEY_USER_SCORE);
		this.attemptStartTime = json.getLong(KEY_ATTEMPT_START_TIME);
		this.attemptEndTime = json.getLong(KEY_ATTEMPT_END_TIME);

		JSONArray answersJSONArray = json.getJSONArray(KEY_ANSWERS);
		for (int i = 0; i < answersJSONArray.length(); i++) {
			JSONObject answerJSON = (JSONObject) answersJSONArray.get(i);
			Answer answer = new Answer();
			answer.fromJSON(answerJSON);
			this.answers.add(answer);
		}
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put(KEY_CODE, this.code);
			json.put(KEY_USER_ID, this.userId);
			json.put(KEY_ATTEMPT_ID, this.attemptId);
			json.put(KEY_MAX_SCORE, this.maxScore);
			json.put(KEY_USER_SCORE, this.userScore);
			json.put(KEY_ATTEMPT_START_TIME, this.attemptStartTime);
			json.put(KEY_ATTEMPT_END_TIME, this.attemptEndTime);
			json.put(KEY_ANSWERS, JSONUtils.toJSONArray(this.answers));
		} catch (JSONException e) {
			// swallow
		}
		return json;
	}

	public String toString() {
		return "{code:" + code + ", userId:" + userId + ", attemptId:"
				+ attemptId + ", maxScore:" + maxScore + ", userScore:"
				+ userScore + ", attemptStartTime:" + attemptStartTime
				+ ", attemptEndTime:" + attemptEndTime + ", answers:" + answers
				+ "}";
	}

	private static final String KEY_CODE = "code";
	private static final String KEY_USER_ID = "userId";
	private static final String KEY_ATTEMPT_ID = "attemptId";
	private static final String KEY_MAX_SCORE = "maxScore";
	private static final String KEY_USER_SCORE = "userScore";
	private static final String KEY_ATTEMPT_START_TIME = "attemptStartTime";
	private static final String KEY_ATTEMPT_END_TIME = "attemptEndTime";
	private static final String KEY_ANSWERS = "answers";

}
