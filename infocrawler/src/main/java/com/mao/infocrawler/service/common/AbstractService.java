package com.mao.infocrawler.service.common;

import com.mao.infocrawler.model.dao.common.IOperations;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mao on 2016/5/1.
 */

@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {

    protected abstract IOperations<T> getDao();

    @Override
    public T findOneById(final int id) {
        return getDao().findOneById(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public void create(final T entity) {
        getDao().create(entity);
    }

    @Override
    public T update(final T entity) {
        return getDao().update(entity);
    }

    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(int entityId) {
        getDao().deleteById(entityId);
    }

}