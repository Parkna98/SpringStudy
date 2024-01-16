package com.sist.dao;
import java.util.*;
import org.apache.ibatis.annotations.Select;

public interface SeoulMapper {
	@Select("SELECT no,title FROM seoul_shop ORDER BY no ASC")
	public List<SeoulVO> shopListData();
	
	@Select("SELECT no,title,msg,address FROM seoul_shop "
			+ "WHERE no=#{no}")
	public SeoulVO shopDetailData(int no);
	
	@Select("SELECT no,title FROM seoul_shop "
			+ "WHERE title LIKE '%'||#{fd}||'%'")
	public List<SeoulVO> shopFindData(String fd);
	
}
