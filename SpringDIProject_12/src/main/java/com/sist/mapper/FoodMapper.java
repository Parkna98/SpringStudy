package com.sist.mapper;
import java.util.*;
import com.sist.dao.*;

public interface FoodMapper {
	/*
	 * namespace="com.sist.mapper.FoodMapper"
	 * <select id="foodFindData" resultType="FoodVO" parameterType="hashmap">
	     SELECT fno,name,type,address,price,time,content
	     FROM food_menu_house
	     WHERE ${col_name} LIKE '%'||#{ss}||'%'
	   </select>
	   동적 쿼리같은 복잡한 쿼리의 경우 xml로 sql을 써서 데이터를 받아온다
	   annotation 안에 문자열로 sql코딩이 길어진다면 xml을 쓰자
	 * 
	 */
	public List<FoodVO> foodFindData(Map map);
}
