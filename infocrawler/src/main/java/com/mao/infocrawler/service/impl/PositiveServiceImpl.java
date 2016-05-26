package com.mao.infocrawler.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mao.infocrawler.model.dao.PositiveDao;
import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.Positive;
import com.mao.infocrawler.service.PositiveService;
import com.mao.infocrawler.service.common.AbstractService;


@Service("positiveService")
public class PositiveServiceImpl extends AbstractService<Positive> implements PositiveService {

    @Resource(name = "positiveDao")
    private PositiveDao dao;

    public PositiveServiceImpl() {
        super();
    }

    @Override
    protected IOperations<Positive> getDao() {
        return this.dao;
    }

	@Override
	public List<Positive> findRandomTwoPositive(String sql) {
		return dao.findRandomTwoPositive(sql);
	}
	
    
}

	
