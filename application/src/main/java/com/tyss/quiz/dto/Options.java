package com.tyss.quiz.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "options")
public class Options implements Serializable {

	@Id
	@Column(name = "question_id")
	private int questionId;
	@Column(name = "option_one")
	private String optionOne;
	@Column(name = "option_two")
	private String optionTwo;
	@Column(name = "option_three")
	private String optionThree;
	@Column(name = "option_four")
	private String optionFour;

	public Options(int questionId, String optionOne, String optionTwo, String optionThree, String optionFour) {
		this.questionId = questionId;
		this.optionOne = optionOne;
		this.optionTwo = optionTwo;
		this.optionThree = optionThree;
		this.optionFour = optionFour;
	}

	public Options() {

	}

	public String getOptionOne() {
		return optionOne;
	}

	public void setOptionOne(String optionOne) {
		this.optionOne = optionOne;
	}

	public String getOptionTwo() {
		return optionTwo;
	}

	public void setOptionTwo(String optionTwo) {
		this.optionTwo = optionTwo;
	}

	public String getOptionThree() {
		return optionThree;
	}

	public void setOptionThree(String optionThree) {
		this.optionThree = optionThree;
	}

	public String getOptionFour() {
		return optionFour;
	}

	public void setOptionFour(String optionFour) {
		this.optionFour = optionFour;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	@Override
	public String toString() {
		return "Options [questionId=" + questionId + ", optionOne=" + optionOne + ", optionTwo=" + optionTwo
				+ ", optionThree=" + optionThree + ", optionFour=" + optionFour + "]";
	}

}
