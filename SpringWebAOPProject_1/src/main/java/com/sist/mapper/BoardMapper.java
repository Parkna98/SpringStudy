package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.dao.*;
public interface BoardMapper {
	// 1. 목록
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,group_tab,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,group_tab,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate,hit,group_tab "
			+ "FROM springReplyBoard ORDER BY group_id desc, group_step ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	// 1-1
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springReplyBoard")
	public int boardTotalPage();
	// 2. 상세 보기
	@Update("UPDATE springReplyBoard SET hit=hit+1 WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,subject,name,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit "
			+ "FROM springReplyBoard "
			+ "WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	// 3. 추가
	@Insert("INSERT INTO springReplyBoard(no,name,subject,content,pwd,group_id) "
			+"VALUES(sr_no_seq.nextval,#{name},#{subject},#{content},#{pwd}, "
			+ "(SELECT NVL(MAX(group_id)+1,1) FROM springReplyBoard))")
	public void boardInsert(BoardVO vo);
			
	// 4. 수정
	@Select("SELECT pwd FROM springReplyBoard WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	@Update("UPDATE springReplyBoard SET "
			+ "name=#{name},subject=#{subject},content=#{content} "
			+ "WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
	// 5. 삭제 => 트랜잭션 적용
	// 6. 답변 => 트랜잭션 적용
	// 7. 찾기 => 동적쿼리
	// AOP =>실시간 추적 (로그), 실시간으로 인기 게시물/
}
