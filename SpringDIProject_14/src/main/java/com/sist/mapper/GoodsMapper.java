package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;
public interface GoodsMapper {
	// vo에 등록된 변수명으로 맞춰야한다!
	@Select("SELECT no,goods_name as name "
			+ "FROM ${table_name} ORDER BY no ASC")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT no,goods_name as name,goods_price as price,goods_sub as sub,goods_discount as discount "
			+ "FROM ${table_name} "
			+ "WHERE no=#{no} "
			+ "ORDER BY no ASC")
	public GoodsVO goodsDetailData(Map map);
}
