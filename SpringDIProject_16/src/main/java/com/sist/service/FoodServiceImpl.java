package com.sist.service;
import com.sist.dao.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fService")
public class FoodServiceImpl implements FoodService{
	@Autowired 
	private FoodDAO dao;

	@Override
	public List<FoodVO> foodListData(String type) {
		// TODO Auto-generated method stub
		return dao.foodListData(type);
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return dao.foodDetailData(fno);
	}
}
