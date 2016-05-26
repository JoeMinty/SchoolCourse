package com.mao.infocrawler.service;

import java.util.List;

import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.Choose;


public interface ExamChooseService extends IOperations<Choose>  {

	 List<Choose> findRandomEightChoose(String sql);

}
