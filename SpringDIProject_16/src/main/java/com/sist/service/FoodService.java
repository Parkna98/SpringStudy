package com.sist.service;

import java.util.List;

import com.sist.dao.FoodVO;

public interface FoodService {
	public List<FoodVO> foodListData(String type);
	public FoodVO foodDetailData(int fno);
}

/*
 * 	Service => DAO여러개 가져다놓고 
 * 			   인터페이스 상속받아서 각자의 DAO 작업 => 오류방지
 * 
 */
