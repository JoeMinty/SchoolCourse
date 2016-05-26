package com.mao.infocrawler.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mao.infocrawler.model.dao.HomeworkDao;
import com.mao.infocrawler.model.dao.common.AbstractHibernateDao;
import com.mao.infocrawler.model.entity.Homework;


@Repository("homeworkDao")
public class HomeworkDaoImpl extends AbstractHibernateDao<Homework> implements HomeworkDao {

    public HomeworkDaoImpl() {
        super();
        setClazz(Homework.class);
    }

	@Override
	public List<Homework> findAllByTime(String sql) {
		  return getCurrentSession().createSQLQuery(sql).addEntity(Homework.class).list();
	}

	@Override
	public int findAnswerCount(String sql) {
		return Integer.parseInt(getCurrentSession().createSQLQuery(sql).list().get(0).toString());
	}

	
	
}
