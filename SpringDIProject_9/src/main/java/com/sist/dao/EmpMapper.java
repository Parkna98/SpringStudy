package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
/*
		<resultMap>
			<result property="dvo.dname" column="dname">
		</resultMap>
		
		dvo.setDname(rs.getString("dname"))
		rs.getString(int index)
		rs.getString(String column) => mybatis에서는 컬럼명을 요청
 */
import org.apache.ibatis.annotations.Select;
public interface EmpMapper {
	// resultMap과 같은 기능
	// 다른테이블에 조인을 걸어 데이터를 들고올때 Results, Result(property,column) 사용
	@Results({
		@Result(property = "dvo.dname",column = "dname"),
		@Result(property = "dvo.loc",column = "loc"), // dvo.setLoc()
	})
	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal,dname,loc "
			+ "FROM emp JOIN dept "
			+ "ON emp.deptno=dept.deptno")
	public List<EmpVO> empDeptJoinData();
	// 보다 높은 안정성, 편리함
	
}
