package com.mao.infocrawler.service;

import java.util.List;

import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.Answers;


public interface AnswersService extends IOperations<Answers> {
	
	List<Answers> findAllByTime(String sql);
	
	boolean addAnswer(String questionid,String answercontent,String time,String answerusername);
	
	List<String> getHotQuestions(String sql);
}
