package com.sist.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.dao.DataBoardVO;

/*
	private int no,hit,filecount;
	private String name,subject,content,pwd,filename,filesize,dbday;
	private Date regdate;
	private List<MultipartFile> files;
 */
public interface DataBoardMapper {
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM (SELECT /*+ INDEX_DESC(springDataBoard sdb_no_pk)*/ no,subject,name,regdate,hit "
			+ "FROM springDataBoard)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> dataBoardListData(@Param("start") int start, @Param("end") int end); 
	
	@Insert("INSERT INTO springDataBoard VALUES("
			+ "sdb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},SYSDATE,0,#{filename},"
			+ "#{filesize},#{filecount})")
	public void databoardInsert(DataBoardVO vo);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springDataBoard")
	public int databoardTotalPage();
	
	@Update("UPDATE springDataBoard SET hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,"
			+ "filename,filesize,filecount "
			+ "FROM springDataBoard "
			+ "WHERE no=#{no}")
	public DataBoardVO databoardDetailData(int no);
	// 삭제관련
	@Select("SELECT filename,filecount "
	+"FROM springDataBoard Where no=#{no}")
	public DataBoardVO databoardFileInfoData(int no);
	
	@Select("SELECT pwd FROM springDataBoard " 
			+"WHERE no=#{no}")
	public String databoardGetPassWord(int no);
	
	@Delete("DELETE FROM springDataBoard "
			+ "WHREE no=#{no}")
	public void databoardDelete(int no);
		
	// 수정관련
	@Update("UPDATE springDataBoard SET "
			+ "name=#{name},subject=#{subject},content=#{content},"
			+ "filename=#{filename},filesize=#{filesize},filecount=#{filecount} "
			+ "WHERE no=#{no}")
	public void databoardUpdate(DataBoardVO vo);
	
	
	
	
	
	
	
	
}
