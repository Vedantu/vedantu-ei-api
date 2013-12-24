package com.vedantu.ei.requests.pojos;

import java.util.ArrayList;
import java.util.List;

public class Attempt {

    private String       code;
    private String       userId;
    private String       attemptId;
    private float        maxScore;
    private float        userScore;
    private long         attemptStartTime;
    private long         attemptEndTime;
    private List<Answer> answers = new ArrayList<Answer>();

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

    public List<Answer> getAnswers() {

        return answers;
    }

    public void setAnswers(List<Answer> answers) {

        this.answers = answers;
    }

    public void addAnswers(Answer... answers) {

        if (answers != null) {
            for (int i = 0; i < answers.length; i++) {
                this.answers.add(answers[i]);
            }
        }
    }

    public void addAnswer(Answer answer) {

        this.answers.add(answer);
    }

}
