package com.mao.infocrawler.model.dao.common;

import com.google.common.base.Preconditions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mao on 2016/5/1.
 */

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T extends Serializable> implements IOperations<T> {

    private Class<T> clazz;

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    protected final void setClazz(final Class<T> clazzToSet) {
        this.clazz = Preconditions.checkNotNull(clazzToSet);
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     *
     */
    protected final void close() {
        sessionFactory.getCurrentSession().close();
    }
    
    
    @Override
    public final T findOneById(final int id) {
        return (T)getCurrentSession().get(clazz, id);
    }

    @Override
    public final List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    @Override
    public final void create(final T entity) {
        Preconditions.checkNotNull(entity);
        // getCurrentSession().persist(entity);
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public final T update(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().update(entity);
        return entity;
        //return (T)getCurrentSession().merge(entity);
    }

    @Override
    public final void delete(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
    }

    @Override
    public final void deleteById(final int entityId) {
        final T entity = findOneById(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }

}