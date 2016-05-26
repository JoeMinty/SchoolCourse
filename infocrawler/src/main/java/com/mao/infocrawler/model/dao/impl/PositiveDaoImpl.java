package com.mao.infocrawler.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mao.infocrawler.model.dao.PositiveDao;
import com.mao.infocrawler.model.dao.common.AbstractHibernateDao;
import com.mao.infocrawler.model.entity.Positive;


@Repository("positiveDao")
public class PositiveDaoImpl extends AbstractHibernateDao<Positive> implements PositiveDao {

    public PositiveDaoImpl() {
        super();
        setClazz(Positive.class);
    }

	@Override
	public List<Positive> findRandomTwoPositive(String sql) {
		return getCurrentSession().createSQLQuery(sql).addEntity(Positive.class).list();
	}

}