package com.vedantu.ei.requests.pojos;

public class Answer {

	private String questionNumber;
	private String userAnswer;
	private boolean isAttempted;
	private boolean isCorrect;
	private float maxScore;
	private float userScore;
	private long timeTaken;

	public String getQuestionNumber() {

		return questionNumber;
	}

	public void setQuestionNumber(String questionNumber) {

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

}
