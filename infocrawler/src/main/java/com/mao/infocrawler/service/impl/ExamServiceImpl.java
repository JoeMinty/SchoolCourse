package com.mao.infocrawler.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mao.infocrawler.model.dao.ExamDao;
import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.Exam;
import com.mao.infocrawler.service.ExamService;
import com.mao.infocrawler.service.common.AbstractService;


@Service("examService")
public class ExamServiceImpl extends AbstractService<Exam> implements ExamService {

    @Resource(name = "examDao")
    private ExamDao dao;

    public ExamServiceImpl() {
        super();
    }

    @Override
    protected IOperations<Exam> getDao() {
        return this.dao;
    }

	@Override
	public List<Exam> findAllByOneStudentId(String id) {
		return dao.findAllByOneStudentId(id);
	}

	@Override
	public int findNoScanCount(String sql) {
		return dao.findNoScanCount(sql);
	}

	@Override
	public int findStudentNoScanCount(String sql) {
		return dao.findStudentNoScanCount(sql);
	}

	@Override
	public List<Exam> findNoScanExams(String sql) {
		return dao.findNoScanExams(sql);
	}
}

	
