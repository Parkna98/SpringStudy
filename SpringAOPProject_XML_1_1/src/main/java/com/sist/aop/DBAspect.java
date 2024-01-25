package com.sist.aop;

import com.sist.dao.EmpDAO;

public class DBAspect {
	private EmpDAO dao;

	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	
	public void before() {
		dao.getConnection();
	}
	
	public void after() {
		dao.disConnection();
	}
}
