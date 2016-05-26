package com.mao.infocrawler.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mao.infocrawler.model.dao.QAndADao;
import com.mao.infocrawler.model.dao.common.AbstractHibernateDao;
import com.mao.infocrawler.model.entity.Answers;
import com.mao.infocrawler.model.entity.Question;


@Repository("qAndADao")
public class QAndADaoImpl extends AbstractHibernateDao<Question> implements QAndADao {

    public QAndADaoImpl() {
        super();
        setClazz(Question.class);
    }

	@Override
	public List<Question> findAllByTime(String sql) {
		  return getCurrentSession().createSQLQuery(sql).addEntity(Question.class).list();
	}

	@Override
	public int findAnswerCount(String sql) {
		return Integer.parseInt(getCurrentSession().createSQLQuery(sql).list().get(0).toString());
	}

	
	
}
