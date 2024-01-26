package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

/*
 * private int no,goods_discount,hit;
	private String goods_name,goods_sub,goods_price,goods_first_price,goods_delivery,goods_poster;
 */
import com.sist.vo.*;
public interface GoodsMapper {
	@Select("SELECT no,goods_poster,goods_name,goods_price,num "
			+ "FROM (SELECT no,goods_poster,goods_name,goods_price,rownum as num "
			+ "FROM (SELECT no,goods_poster,goods_name,goods_price "
			+ "FROM ${tab_name} ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsAllListData(@Param("start") int start,@Param("end") int end,@Param("tab_name") String tab_name);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM ${tab_name}")
	public int goodsAllTotalPage(@Param("tab_name") String tab_name);
	
	@Update("UPDATE ${tab_name} SET hit=hit+1 "
			+ "WHERE no=#{no}")
	public void goodsAllHitIncrement(@Param("no") int no,@Param("tab_name") String tab_name);
	
	@Select("SELECT no,goods_name,goods_sub,goods_price,goods_first_price,goods_delivery,goods_poster,goods_discount,hit "
			+ "FROM ${tab_name} "
			+ "WHERE no=#{no}")
	public GoodsVO goodsAllDetailData(@Param("no") int no,@Param("tab_name") String tab_name);
	
	//검색(이름 기반, 전체, 베스트, 스페셜, 신상품)
	@Select("SELECT no,goods_poster,goods_name,goods_price,num "
			+ "FROM (SELECT no,goods_poster,goods_name,goods_price,rownum as num "
			+ "FROM (SELECT no,goods_poster,goods_name,goods_price "
			+ "FROM ${tab_name} "
			+ "WHERE goods_name LIKE '%'||#{ss}||'%' " 
			+ "ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsAllFindListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM ${tab_name} "
			+ "WHERE goods_name LIKE '%'||#{ss}||'%'")
	public int goodsAllFindTotalPage(Map map);
	
	// 댓글
	// 추가
	@SelectKey(keyProperty = "no",resultType = int.class,before = true,statement = "SELECT NVL(MAX(no)+1,1) as no FROM goodsReply")
	@Insert("INSERT INTO goodsReply VALUES("
			+ "#{no},#{gno},#{type},#{id},#{name},#{msg},SYSDATE)")
	public void goodsReplyInsert(GoodsReplyVO vo);
	// 목록
	@Select("SELECT no,gno,type,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD') as dbday "
			+ "FROM goodsReply "
			+ "WHERE #{gno}=gno AND #{type}=type "
			+ "ORDER BY no DESC")
	public List<GoodsReplyVO> goodsReplyListData(Map map);
	// 수정
	@Update("UPDATE goodsReply SET "
			+ "msg=#{msg} "
			+ "WHERE no=#{no}")
	public void goodsReplyUpdate(GoodsReplyVO vo);
	// 삭제
	@Delete("DELETE FROM goodsReply "
			+ "WHERE no=#{no}")
	public void goodsReplyDelete(int no);
}
