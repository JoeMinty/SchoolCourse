package com.mao.infocrawler.service;

import java.util.List;

import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.Homework;


public interface HomeworkService extends IOperations<Homework> {
	
	List<Homework> findAllByTime(String sql);
	
	int findAnswerCount(String sql);
	
	boolean addHomework(String homeworkcontent,String description,String askuserid,String username);
	
}
