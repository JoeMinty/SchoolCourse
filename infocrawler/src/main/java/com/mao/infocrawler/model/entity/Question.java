package com.mao.infocrawler.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "_question")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String questionname;

	@Column
	private String askusername;

	@Column
	private String askuserid;

	@Column
	private String description;

	@Column
	private String time;

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

}
