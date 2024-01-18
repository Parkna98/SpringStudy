package com.sist.mapper;
import com.sist.dao.*;
import java.util.*;
public interface EmpMapper {
	// <select id="empAllData" resultMap="empMap">
	// id=method명
	// resultType,resultMap => 리턴형
	// parameterType => 매개변수와 매칭
	public List<EmpVO> empAllData();
	
	public EmpVO empDetailData(int empno);
}
