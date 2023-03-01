package com.tyss.quiz.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class Questions implements Serializable {
	@Id
	@Column(name = "question_Id")
	private int questionId;
	@Column(name = "question_language")
	private String questionLanguage;
	@Column(name = "question")
	private String questions;
	@Column(name = "answer")
	private String answer;

	public Questions(int questionId, String questionLanguage, String questions, String answer) {
		this.questionId = questionId;
		this.questionLanguage = questionLanguage;
		this.questions = questions;
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Questions() {

	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionLanguage() {
		return questionLanguage;
	}

	public void setQuestionLanguage(String questionLanguage) {
		this.questionLanguage = questionLanguage;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", questionLanguage=" + questionLanguage + ", questions="
				+ questions + ", answer=" + answer + "]";
	}

}
