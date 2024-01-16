package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface SeoulMapper {
	@Select("SELECT no,title FROM seoul_nature "
			+ "ORDER BY no ASC")
	public List<SeoulVO> natureListData();
	
	@Select("SELECT no,title,msg,address "
			+ "FROM seoul_nature "
			+ "WHERE no=#{no}")
	public SeoulVO natureDetailData(int no);
	// JPA
	// public SeoulVO findByNo(int no)
	/*
			public SeoulVO natureDetailData(int no){
				SeoulVO vo=new SeoulVO();
				try{
					getConnection();
					String sql="SELECT ~~";
					ps=conn.preparedStatement(sql);
					ps.setInt(1,no);
					ResultSet rs=ps.executeQuery();
					rs.next();
					vo.setNo(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setMsg(rs.getString(3));
					vo.setAddress(rs.getString(4));
					rs.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}finally{
					disConnection();
				}
				return vo;
			}
	 */
	
	@Select("SELECT no,title FROM seoul_nature "
			+ "WHERE title LIKE '%'||#{fd}||'%'")
	public List<SeoulVO> seoulFindListData(String fd);
}
