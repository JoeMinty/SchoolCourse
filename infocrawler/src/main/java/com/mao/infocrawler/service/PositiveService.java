package com.mao.infocrawler.service;

import java.util.List;

import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.Positive;


public interface PositiveService extends IOperations<Positive>  {
	
	 List<Positive> findRandomTwoPositive(String sql);

}
