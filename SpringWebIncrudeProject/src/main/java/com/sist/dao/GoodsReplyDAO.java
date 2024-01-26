package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class GoodsReplyDAO {
	@Autowired
	private GoodsMapper mapper;
	
	public void goodsReplyInsert(GoodsReplyVO vo) {
		mapper.goodsReplyInsert(vo);
	}
	
	public List<GoodsReplyVO> goodsReplyListData(Map map){
		return mapper.goodsReplyListData(map);
	}
	
	public void goodsReplyUpdate(GoodsReplyVO vo) {
		mapper.goodsReplyUpdate(vo);
	}
	
	public void goodsReplyDelete(int no) {
		mapper.goodsReplyDelete(no);
	}
}
