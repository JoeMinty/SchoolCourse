package com.mao.infocrawler.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mao.infocrawler.model.dao.AnswersDao;
import com.mao.infocrawler.model.dao.common.AbstractHibernateDao;
import com.mao.infocrawler.model.entity.Answers;


@Repository("answersDao")
public class AnswersDaoImpl extends AbstractHibernateDao<Answers> implements AnswersDao {

    public AnswersDaoImpl() {
        super();
        setClazz(Answers.class);
    }

	@Override
	public List<Answers> findAllByTime(String sql) {
		  return getCurrentSession().createSQLQuery(sql).addEntity(Answers.class).list();
	}

}
