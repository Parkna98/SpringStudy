package com.sist.dao;
import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;
// 상속 sqlsessiondaosupport
// => session 열고 닫기, update 등 자동 커밋
public class EmpDAO extends SqlSessionDaoSupport{
	public List<EmpVO> empListData(){
		return getSqlSession().selectList("empListData");
	}
	
	public EmpVO empDetailData(int empno) {
		return getSqlSession().selectOne("empDetailData",empno);
	}
	
}
