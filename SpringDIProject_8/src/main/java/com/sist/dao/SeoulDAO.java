package com.sist.dao;
import java.util.*;

public class SeoulDAO {
	private SeoulMapper mapper;

	public void setMapper(SeoulMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<SeoulVO> shopListData(){
		return mapper.shopListData();
	}
	
	public SeoulVO shopDetailData(int no) {
		return mapper.shopDetailData(no);
	}
	
	public List<SeoulVO> shopFindData(String fd){
		return mapper.shopFindData(fd);
	}
	
}
