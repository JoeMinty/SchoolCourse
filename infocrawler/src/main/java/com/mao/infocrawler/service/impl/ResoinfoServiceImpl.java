package com.mao.infocrawler.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mao.infocrawler.model.dao.ResoinfoDao;
import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.Resoinfo;
import com.mao.infocrawler.service.ResoinfoService;
import com.mao.infocrawler.service.common.AbstractService;


@Service("resoinfoService")
public class ResoinfoServiceImpl extends AbstractService<Resoinfo> implements ResoinfoService {

	
	@Resource(name = "resoinfoDao")
    private ResoinfoDao dao;

    public ResoinfoServiceImpl() {
        super();
    }
	
	@Override
	protected IOperations<Resoinfo> getDao() {
		
		return this.dao;
	}

	@Override
	public List<Resoinfo> findOneTeacherAllResources(String id) {
		String sql = "select * from _resoinfo where teacherid='"+id+"'";
		return dao.query(sql);
	}

	@Override
	public void update(String sql) {
		dao.updateDownloadNum(sql);
	}

}
