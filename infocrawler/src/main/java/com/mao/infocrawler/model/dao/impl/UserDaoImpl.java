package com.mao.infocrawler.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mao.infocrawler.model.dao.UserDao;
import com.mao.infocrawler.model.dao.common.AbstractHibernateDao;
import com.mao.infocrawler.model.entity.User;


@Repository("userDao")
public class UserDaoImpl extends AbstractHibernateDao<User> implements UserDao {

    public UserDaoImpl() {
        super();
        setClazz(User.class);
    }

    /**
     * for query
     *
     * @param sql
     * @return
     */
	@Override
    public List<User> query(final String sql) {
        return getCurrentSession().createSQLQuery(sql).addEntity(User.class).list();
    }
    
	@Override
	public User findOneUser(String sql) {
		return (User) getCurrentSession().createSQLQuery(sql).addEntity(User.class).list().get(0);
	}

	@Override
	public int queryCount(String sql) {
		return Integer.parseInt(getCurrentSession().createSQLQuery(sql).list().get(0).toString());
	}
    
   
}
