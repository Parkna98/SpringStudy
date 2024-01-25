package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> goodsAllListData(int start,int end, String tab_name){
		return mapper.goodsAllListData(start, end, tab_name);
	}
	
	public int goodsAllTotalPage(String tab_name) {
		return mapper.goodsAllTotalPage(tab_name);
	}
	
	public GoodsVO goodsAllDetailData(int no,String tab_name) {
		mapper.goodsAllHitIncrement(no,tab_name);
		return mapper.goodsAllDetailData(no,tab_name);
	}
	
	public GoodsVO goodsAllCookieData(int no,String tab_name) {
		return mapper.goodsAllDetailData(no,tab_name);
	}
	
	public List<GoodsVO> goodsAllFindListData(Map map){
		return mapper.goodsAllFindListData(map);
	}
	
	public int goodsAllFindTotalPage(Map map) {
		return mapper.goodsAllFindTotalPage(map);
	}
}
