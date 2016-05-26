package com.mao.infocrawler.service;

import java.util.List;

import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.Resoinfo;


public interface ResoinfoService extends IOperations<Resoinfo> {
	
	public List<Resoinfo> findOneTeacherAllResources(String id);
	
	public void update(String sql);
	
}
