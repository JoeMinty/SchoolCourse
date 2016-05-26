package com.mao.infocrawler.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mao.infocrawler.model.dao.ChooseDao;
import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.Choose;
import com.mao.infocrawler.service.ExamChooseService;
import com.mao.infocrawler.service.common.AbstractService;


@Service("examChooseService")
public class ExamChooseServiceImpl extends AbstractService<Choose> implements ExamChooseService {

    @Resource(name = "chooseDao")
    private ChooseDao dao;

    public ExamChooseServiceImpl() {
        super();
    }

    @Override
    protected IOperations<Choose> getDao() {
        return this.dao;
    }

	@Override
	public List<Choose> findRandomEightChoose(String sql) {
		return dao.findRandomEightChoose(sql);
	}
}
