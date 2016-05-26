package com.mao.infocrawler.service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mao.infocrawler.model.dao.QAndADao;
import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.Question;
import com.mao.infocrawler.service.QAndAService;
import com.mao.infocrawler.service.common.AbstractService;


@Service("qAndAService")
public class QAndAServiceImpl extends AbstractService<Question> implements QAndAService {

	
	@Resource(name = "qAndADao")
    private QAndADao dao;

    public QAndAServiceImpl() {
        super();
    }
	
	@Override
	protected IOperations<Question> getDao() {
		return this.dao;
	}

	@Override
	public List<Question> findAllByTime(String sql) {
		return dao.findAllByTime(sql);
	}

	@Override
	public int findAnswerCount(String sql) {
		return dao.findAnswerCount(sql);
	}

	@Override
	public boolean addQuestion(String questionname,String description,String askuserid,String username) {
		boolean result = true;
		Question question = new Question();
		question.setAskuserid(askuserid);
		question.setDescription(description);
		question.setAskusername(username);
		question.setQuestionname(questionname);
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		Date time = new Date();
		question.setTime(myFmt.format(time));
		try{
			dao.create(question);
		}catch(Exception e){
			result = false;
			return result;
		}
		return result;
	}

	

	

}
