package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface EmpMapper {
	// <select id="" resultType="" parameterType>
	@Select("SELECT empno,ename,job,hiredate,sal,deptno "
			+"FROM emp")
	public List<EmpVO> empListData();
	//     resultType	  id	  parameterType
	// annotation 쓰는법 잘 기억
	// id와 resultType과 parameterType이 각각 메소드명 리턴형 매개변수로 지정
	
}
