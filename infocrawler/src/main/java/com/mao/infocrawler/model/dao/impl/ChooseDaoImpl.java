package com.mao.infocrawler.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mao.infocrawler.model.dao.ChooseDao;
import com.mao.infocrawler.model.dao.common.AbstractHibernateDao;
import com.mao.infocrawler.model.entity.Choose;
import com.mao.infocrawler.model.entity.Question;


@Repository("chooseDao")
public class ChooseDaoImpl extends AbstractHibernateDao<Choose> implements ChooseDao {

    public ChooseDaoImpl() {
        super();
        setClazz(Choose.class);
    }

	@Override
	public List<Choose> findRandomEightChoose(String sql) {
		return getCurrentSession().createSQLQuery(sql).addEntity(Choose.class).list();
	}
}
