package com.tyss.quiz.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Results implements Serializable {
	@Id
	@Column(name = "result_id")
	private int resultId;
	@Column(name = "user_id")

	private int userId;
	@Column(name = "score")

	private int score;
	@Column(name = "question_language")
	private String questionLanguage;

	public Results(int resultId, int userId, int score, String questionLanguage) {
		this.resultId = resultId;
		this.userId = userId;
		this.score = score;
		this.questionLanguage = questionLanguage;
	}

	public String getQuestionLanguage() {
		return questionLanguage;
	}

	public void setQuestionLanguage(String questionLanguage) {
		this.questionLanguage = questionLanguage;
	}

	public Results(int userId, int score, String questionLanguage) {
		this.userId = userId;
		this.score = score;
		this.questionLanguage = questionLanguage;
	}

	public Results() {

	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Results [resultId=" + resultId + ", userId=" + userId + ", score=" + score + ", questionLanguage="
				+ questionLanguage + "]";
	}

}
