package com.mao.infocrawler.service;

import java.util.List;

import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.Question;


public interface QAndAService extends IOperations<Question> {
	
	List<Question> findAllByTime(String sql);
	
	int findAnswerCount(String sql);
	
	boolean addQuestion(String questionname,String description,String askuserid,String username);
	
	List<String> getHotQuestions(String sql);
}
