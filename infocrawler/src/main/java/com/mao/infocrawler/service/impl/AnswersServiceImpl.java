package com.mao.infocrawler.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mao.infocrawler.model.dao.AnswersDao;
import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.Answers;
import com.mao.infocrawler.service.AnswersService;
import com.mao.infocrawler.service.common.AbstractService;


@Service("answersService")
public class AnswersServiceImpl extends AbstractService<Answers> implements AnswersService {

	
	@Resource(name = "answersDao")
    private AnswersDao dao;

    public AnswersServiceImpl() {
        super();
    }
	
	@Override
	protected IOperations<Answers> getDao() {
		return this.dao;
	}

	@Override
	public List<Answers> findAllByTime(String sql) {
		return dao.findAllByTime(sql);
	}

	@Override
	public boolean addAnswer(String questionid, String answercontent,
			String time, String answerusername) {
		boolean result = true;
		Answers answer = new Answers();
		answer.setQuestionid(questionid);
		answer.setAnswers(answercontent);
		answer.setTime(time);
		answer.setAnswerusername(answerusername);
		try{
			dao.create(answer);
		}catch(Exception e){
			result = false;
			return result;
		}
		return result;
	}

	@Override
	public List<String> getHotQuestions(String sql) {
		return dao.getHotQuestions(sql);
	}

}
