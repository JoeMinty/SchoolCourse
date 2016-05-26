package com.mao.infocrawler.service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mao.infocrawler.model.dao.HomeworkDao;
import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.Homework;
import com.mao.infocrawler.service.HomeworkService;
import com.mao.infocrawler.service.common.AbstractService;


@Service("homeworkService")
public class HomeworkServiceImpl extends AbstractService<Homework> implements HomeworkService {

	
	@Resource(name = "homeworkDao")
    private HomeworkDao dao;

    public HomeworkServiceImpl() {
        super();
    }
	
	@Override
	protected IOperations<Homework> getDao() {
		return this.dao;
	}

	@Override
	public List<Homework> findAllByTime(String sql) {
		return dao.findAllByTime(sql);
	}

	@Override
	public int findAnswerCount(String sql) {
		return dao.findAnswerCount(sql);
	}

	@Override
	public boolean addHomework(String homeworkcontent,String description,String teacherid,String username) {
		boolean result = true;
		Homework homework = new Homework();
		homework.setHomeworkcontent(homeworkcontent);
		homework.setDescription(description);
		homework.setTeachername(username);
		homework.setTeacherid(teacherid);
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		Date time = new Date();
		homework.setTime(myFmt.format(time));
		try{
			dao.create(homework);
		}catch(Exception e){
			result = false;
			return result;
		}
		return result;
	}

}
