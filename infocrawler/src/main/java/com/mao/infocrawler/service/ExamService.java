package com.mao.infocrawler.service;

import java.util.List;

import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.Exam;


public interface ExamService extends IOperations<Exam>  {
	
	List<Exam> findAllByOneStudentId(String id);
	
	List<Exam> findNoScanExams(String sql);
	
	int findNoScanCount(String sql);
	
	int findStudentNoScanCount(String sql);

	
}
