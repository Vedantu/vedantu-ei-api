package com.vedantu.ei.requests.pojos;

import org.json.JSONException;
import org.json.JSONObject;

import com.vedantu.ei.commons.JSONAware;

public class Answer implements JSONAware {

	private int questionNumber; // 0 based index
	private String userAnswer;
	private boolean isAttempted;
	private boolean isCorrect;
	private float maxScore;
	private float userScore;
	private long timeTaken;

	public int getQuestionNumber() {

		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {

		this.questionNumber = questionNumber;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public boolean isAttempted() {

		return isAttempted;
	}

	public void setAttempted(boolean isAttempted) {

		this.isAttempted = isAttempted;
	}

	public boolean isCorrect() {

		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {

		this.isCorrect = isCorrect;
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

	public long getTimeTaken() {

		return timeTaken;
	}

	public void setTimeTaken(long timeTaken) {

		this.timeTaken = timeTaken;
	}

	public void fromJSON(JSONObject json) throws JSONException {
		this.questionNumber = json.getInt(KEY_QUESTION_NUMBER);
		this.userAnswer = json.getString(KEY_USER_ANSWER);
		this.isAttempted = json.getBoolean(KEY_IS_ATTEMPTED);
		this.isCorrect = json.getBoolean(KEY_IS_CORRECT);
		this.maxScore = (float) json.getDouble(KEY_MAX_SCORE);
		this.userScore = (float) json.getDouble(KEY_USER_SCORE);
		this.timeTaken = json.getLong(KEY_TIME_TAKEN);
	}

	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		try {
			json.put(KEY_QUESTION_NUMBER, this.questionNumber);
			json.put(KEY_USER_ANSWER, this.userAnswer);
			json.put(KEY_IS_ATTEMPTED, this.isAttempted);
			json.put(KEY_IS_CORRECT, this.isCorrect);
			json.put(KEY_MAX_SCORE, this.maxScore);
			json.put(KEY_USER_SCORE, this.userScore);
			json.put(KEY_TIME_TAKEN, this.timeTaken);
		} catch (JSONException e) {
			// swallow
		}
		return json;
	}

	private static final String KEY_QUESTION_NUMBER = "questionNumber";
	private static final String KEY_USER_ANSWER = "userAnswer";
	private static final String KEY_IS_ATTEMPTED = "isAttempted";
	private static final String KEY_IS_CORRECT = "isCorrect";
	private static final String KEY_MAX_SCORE = "maxScore";
	private static final String KEY_USER_SCORE = "userScore";
	private static final String KEY_TIME_TAKEN = "timeTaken";

}
