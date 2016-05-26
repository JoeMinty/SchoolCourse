package com.mao.infocrawler.model.entity;

import java.io.Serializable;

public class QuestionInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String questionname;

	private String askusername;

	private String askuserid;

	private String description;

	private String time;
	
	private int answernum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionname() {
		return questionname;
	}

	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}

	public String getAskusername() {
		return askusername;
	}

	public void setAskusername(String askusername) {
		this.askusername = askusername;
	}

	public String getAskuserid() {
		return askuserid;
	}

	public void setAskuserid(String askuserid) {
		this.askuserid = askuserid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getAnswernum() {
		return answernum;
	}

	public void setAnswernum(int answernum) {
		this.answernum = answernum;
	}

}
