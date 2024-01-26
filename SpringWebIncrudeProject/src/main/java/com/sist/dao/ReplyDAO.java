package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
/*
 * 		.do ====== DispatcherServlet
 * 						 ㅣ => preHandler() => 자동 로그인 / ID저장
 * 						 ㅣ HandlerMapping
 * 						@Controller / @RestController
						 ㅣ => postHandler  
 						 ㅣ Model=request => ViewResolver
 						 ㅣ => afterCompletion() => 권한
 						JSP 
 						
 		== MVC
 			ㅣ DI, AOP => Annotation, XML
 			  ===========================
 			  Annotation : 분산작업 시에 개발자마다 (기능별)
 			  XML : 공통기반파일들 => 라이브러리 설정
 		
 		Joinpoint => 위치
 		Pointcut => 수행할 메소드 => execution * ......
 		Advice => Joinpoint + Pointcut
 		Aspect => advice + advice + advice + ... +
 		
 		
 		=> AOP 
 		   void aaa(); => Before
 		   void bbb(); => AfterThrowing
 		   void ccc(); => After
 		   void ddd(); => AfterReturning 
 		   
 		   public String disply()
 		   {
 		   		aaa();
 		   		try{
 		   			================
 		   				핵심 소스
 		   			================
 		   		}catch(Exception ex){
 		   			bbb();
 		   		}finally{
 		   			ccc();
 		   		}
 		   		ddd();
 		   		return "";
 		   		
 		   }
 		   
 		   
 */

@Repository
public class ReplyDAO {
	@Autowired
	private ReplyMapper mapper;
	
	public void replyInsert(ReplyVO vo) {
		mapper.replyInsert(vo);
	}
	
	public List<ReplyVO> replyListData(int fno){
		return mapper.replyListData(fno);
	}
	
	public void replyUpdate(ReplyVO vo) {
		mapper.replyUpdate(vo);
	}
	
	public void replyDelete(int no) {
		mapper.replyDelete(no);
	}
	
}
