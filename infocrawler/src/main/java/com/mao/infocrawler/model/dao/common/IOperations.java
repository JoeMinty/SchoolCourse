package com.mao.infocrawler.model.dao.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mao on 2016/5/1.
 */

/*
 * 通用的操作接口
 */
public interface IOperations<T extends Serializable> {

	
    T findOneById(final int id);

    List<T> findAll();

    void create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final int entityId);

}
