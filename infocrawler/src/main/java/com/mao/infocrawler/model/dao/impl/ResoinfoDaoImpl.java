package com.mao.infocrawler.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mao.infocrawler.model.dao.ResoinfoDao;
import com.mao.infocrawler.model.dao.common.AbstractHibernateDao;
import com.mao.infocrawler.model.entity.Resoinfo;


@Repository("resoinfoDao")
public class ResoinfoDaoImpl extends AbstractHibernateDao<Resoinfo> implements ResoinfoDao {

    public ResoinfoDaoImpl() {
        super();
        setClazz(Resoinfo.class);
    }

    /**
     * for query
     *
     * @param sql
     * @return
     */
	@Override
    public List<Resoinfo> query(final String sql) {
        return getCurrentSession().createSQLQuery(sql).addEntity(Resoinfo.class).list();
    }

	@Override
	public void updateDownloadNum(String sql) {
		getCurrentSession().createSQLQuery(sql).executeUpdate();
	}
   
}
