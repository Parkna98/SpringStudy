package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
/*
 *  DAO vs Service
 *  DAO => 독립적인 dao만들기위함
 *  Service => 기능이 비슷 dao를 모음
 */
@Repository("fDao")
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<FoodVO> foodCategoryListData(int cno){
		return mapper.foodCategoryListData(cno);
	}
	
	public FoodVO foodDetailData(int fno) {
		return mapper.foodDetailData(fno);
	}
}
