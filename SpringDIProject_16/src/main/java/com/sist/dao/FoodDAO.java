package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.mapper.FoodMapper.*;

@Repository("fDao")
public class FoodDAO {
	@Autowired
	
	private FoodMapper mapper;
	
	public List<FoodVO> foodListData(String type){
		return mapper.foodListData(type);
	}
	
	public FoodVO foodDetailData(int fno) {
		return mapper.foodDetailData(fno);
	}
}
