package com.mao.infocrawler.model.dao;

import java.util.List;

import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.Resoinfo;

/**
 * Created by mao on 2016/5/1.
 */
public interface ResoinfoDao extends IOperations<Resoinfo> {

    //让所有的DAO都实现基本的操作接口IOperations
    //除了实现IOperations中的基本操作之外，特定的DAO要实现其他操作可以在对应的接口DAO中定义方法
    List<Resoinfo> query(final String sql);
    
    void updateDownloadNum(final String sql);
   
}
