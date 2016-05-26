package com.mao.infocrawler.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mao.infocrawler.model.dao.ExamDao;
import com.mao.infocrawler.model.dao.common.AbstractHibernateDao;
import com.mao.infocrawler.model.entity.Exam;


@Repository("examDao")
public class ExamDaoImpl extends AbstractHibernateDao<Exam> implements ExamDao {

    public ExamDaoImpl() {
        super();
        setClazz(Exam.class);
    }

	@Override
	public List<Exam> findAllByOneStudentId(String id) {
		String sql = "select * from _exam where studentid='" +id+ "'";
		return getCurrentSession().createSQLQuery(sql).addEntity(Exam.class).list();
	}

	@Override
	public int findNoScanCount(String sql) {
		return getCurrentSession().createSQLQuery(sql).list().size();
	}

	@Override
	public int findStudentNoScanCount(String sql) {
		return getCurrentSession().createSQLQuery(sql).list().size();
	}

	@Override
	public List<Exam> findNoScanExams(String sql) {
		return getCurrentSession().createSQLQuery(sql).addEntity(Exam.class).list();
	}

}