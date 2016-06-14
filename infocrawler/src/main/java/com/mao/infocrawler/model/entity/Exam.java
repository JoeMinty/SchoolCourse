package com.mao.infocrawler.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "_exam")
public class Exam implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String studentid;
	
	@Column
	private String studentname;
	
	@Column
	private int status;
	
	@Column
	private int studentstatus;

	@Column
	private int choosescore;

	@Column
	private String choose1id;
	
	@Column
	private String choose1result;
	
	@Column
	private String choose1realresult;
	
	@Column
	private String choose2id;
	
	@Column
	private String choose2result;
	
	@Column
	private String choose2realresult;
	
	@Column
	private String choose3id;
	
	@Column
	private String choose3result;
	
	@Column
	private String choose3realresult;
	
	@Column
	private String choose4id;
	
	@Column
	private String choose4result;
	
	@Column
	private String choose4realresult;
	
	@Column
	private String choose5id;
	
	@Column
	private String choose5result;
	
	@Column
	private String choose5realresult;
	
	@Column
	private String choose6id;
	
	@Column
	private String choose6result;
	
	@Column
	private String choose6realresult;
	
	@Column
	private String choose7id;
	
	@Column
	private String choose7result;
	
	@Column
	private String choose7realresult;
	
	@Column
	private String choose8id;
	
	@Column
	private String choose8result;
	
	@Column
	private String choose8realresult;
	
	@Column
	private String positive1id;
	
	@Column
	private String positive1result;
	
	@Column
	private int positive1score;
	
	@Column
	private String positive2id;
	
	@Column
	private String positive2result;
	
	@Column
	private int positive2score;
	
	@Column
	private String tempresult;
	
	@Column
	private String time;
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getChoosescore() {
		return choosescore;
	}

	public void setChoosescore(int choosescore) {
		this.choosescore = choosescore;
	}

	public String getChoose1id() {
		return choose1id;
	}

	public void setChoose1id(String choose1id) {
		this.choose1id = choose1id;
	}

	public String getChoose1result() {
		return choose1result;
	}

	public void setChoose1result(String choose1result) {
		this.choose1result = choose1result;
	}

	public String getChoose1realresult() {
		return choose1realresult;
	}

	public void setChoose1realresult(String choose1realresult) {
		this.choose1realresult = choose1realresult;
	}

	public String getChoose2id() {
		return choose2id;
	}

	public void setChoose2id(String choose2id) {
		this.choose2id = choose2id;
	}

	public String getChoose2result() {
		return choose2result;
	}

	public void setChoose2result(String choose2result) {
		this.choose2result = choose2result;
	}

	public String getChoose2realresult() {
		return choose2realresult;
	}

	public void setChoose2realresult(String choose2realresult) {
		this.choose2realresult = choose2realresult;
	}

	public String getChoose3id() {
		return choose3id;
	}

	public void setChoose3id(String choose3id) {
		this.choose3id = choose3id;
	}

	public String getChoose3result() {
		return choose3result;
	}

	public void setChoose3result(String choose3result) {
		this.choose3result = choose3result;
	}

	public String getChoose3realresult() {
		return choose3realresult;
	}

	public void setChoose3realresult(String choose3realresult) {
		this.choose3realresult = choose3realresult;
	}

	public String getChoose4id() {
		return choose4id;
	}

	public void setChoose4id(String choose4id) {
		this.choose4id = choose4id;
	}

	public String getChoose4result() {
		return choose4result;
	}

	public void setChoose4result(String choose4result) {
		this.choose4result = choose4result;
	}

	public String getChoose4realresult() {
		return choose4realresult;
	}

	public void setChoose4realresult(String choose4realresult) {
		this.choose4realresult = choose4realresult;
	}

	public String getChoose5id() {
		return choose5id;
	}

	public void setChoose5id(String choose5id) {
		this.choose5id = choose5id;
	}

	public String getChoose5result() {
		return choose5result;
	}

	public void setChoose5result(String choose5result) {
		this.choose5result = choose5result;
	}

	public String getChoose5realresult() {
		return choose5realresult;
	}

	public void setChoose5realresult(String choose5realresult) {
		this.choose5realresult = choose5realresult;
	}

	public String getChoose6id() {
		return choose6id;
	}

	public void setChoose6id(String choose6id) {
		this.choose6id = choose6id;
	}

	public String getChoose6result() {
		return choose6result;
	}

	public void setChoose6result(String choose6result) {
		this.choose6result = choose6result;
	}

	public String getChoose6realresult() {
		return choose6realresult;
	}

	public void setChoose6realresult(String choose6realresult) {
		this.choose6realresult = choose6realresult;
	}

	public String getChoose7id() {
		return choose7id;
	}

	public void setChoose7id(String choose7id) {
		this.choose7id = choose7id;
	}

	public String getChoose7result() {
		return choose7result;
	}

	public void setChoose7result(String choose7result) {
		this.choose7result = choose7result;
	}

	public String getChoose7realresult() {
		return choose7realresult;
	}

	public void setChoose7realresult(String choose7realresult) {
		this.choose7realresult = choose7realresult;
	}

	public String getChoose8id() {
		return choose8id;
	}

	public void setChoose8id(String choose8id) {
		this.choose8id = choose8id;
	}

	public String getChoose8result() {
		return choose8result;
	}

	public void setChoose8result(String choose8result) {
		this.choose8result = choose8result;
	}

	public String getChoose8realresult() {
		return choose8realresult;
	}

	public void setChoose8realresult(String choose8realresult) {
		this.choose8realresult = choose8realresult;
	}

	public String getPositive1id() {
		return positive1id;
	}

	public void setPositive1id(String positive1id) {
		this.positive1id = positive1id;
	}

	public String getPositive1result() {
		return positive1result;
	}

	public void setPositive1result(String positive1result) {
		this.positive1result = positive1result;
	}

	public int getPositive1score() {
		return positive1score;
	}

	public void setPositive1score(int positive1score) {
		this.positive1score = positive1score;
	}

	public String getPositive2id() {
		return positive2id;
	}

	public void setPositive2id(String positive2id) {
		this.positive2id = positive2id;
	}

	public String getPositive2result() {
		return positive2result;
	}

	public void setPositive2result(String positive2result) {
		this.positive2result = positive2result;
	}

	public int getPositive2score() {
		return positive2score;
	}

	public int getStudentstatus() {
		return studentstatus;
	}

	public void setStudentstatus(int studentstatus) {
		this.studentstatus = studentstatus;
	}

	public void setPositive2score(int positive2score) {
		this.positive2score = positive2score;
	}

	public String getTempresult() {
		return tempresult;
	}

	public void setTempresult(String tempresult) {
		this.tempresult = tempresult;
	}
	
}
