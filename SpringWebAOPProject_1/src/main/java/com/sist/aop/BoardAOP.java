package com.sist.aop;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.dao.*;
/*
 *   AOP 사용처
 *   	=> 모니터링 / 로깅 / 오류 검사(처리) / 성능 파악
 *   	=> 트랜잭션, 보안, 암호화/복호화, 데이터 읽기/분석
 *   
 *   	= 공통 기능을 재사용하는 기법
 *   	= 공통적인 내용을 모아서 관리 => 유지보수
 *   	= 라이브러리 (트랜잭션, 보안)
 *   
 *   Spring FrameWork
 *   	=> DI
 *    	=> AOP
 *    	=> MVC
 *    -----------------------------------------------
 *    1. pointcut
 *    		=> 어떤 클래스의 어떤 메소드에서 적용
 *    		=> execution("특정위치 지정")
 *    		=> within("패키지명")
 *    
 *    2. 메소드 위치 => JoinPoint
 *    		= Before
 *    		= After : finally (무조건 호출)
 *    		= AfterReturning : 정상 수행 => return값을 받을 수 있다
 *      	= AfterThrowing : 에러처리 
 *      	= Around
 *      
 *     3. 인터셉트 (호출하기전이냐 호출한 후이냐)
 *     		=> 자동 로그인, iD 저장
 *    	 public String display()
 *    	{
 *    		before();
 *    		try{
     			=========== SetAutoCommit(false)
     				소스
     			=========== commit()
     
 *    		}catch(Exception e){
 *    			public void afterThrowing() => rollback
 *    		}finally{
 *    			after() => setAutoCommit(true)
 *    		}
 *    		public void afterReturning
 *    		return ""
 *		}    
 *		각 aop별 실행위치를 잘 기억하자!! 
 *			before => try전
 *			after => finally
 *		ex) 
 *			@Before
 *			public void before()
 			{
 			}
 			@After
 			public void after()
 			{
 			}
 			@AfterReturning
 			public void afterReturning
 			{
 			}
 			@AfterThrowing
 			public void afterThrowing()
 			{
 			}
     	 
 */
/*
		브라우저에서 .do 입력 => DispatcherServlet에서 .do찾기 (.do로 설정해놔서 다른거 입력하면 데이터가 들어오지 않는다)
		Model 과 연결
 */
@Aspect
@Component
public class BoardAOP {
	@Autowired
	private BoardDAO dao;
	
	@After("execution (* com.sist.web.*Controller.*(..))")
	public void after() {
		List<BoardVO> list=dao.boardTop5();
		// 실제 사용중인 request를 얻어 올때 사용 => Cookie
		// ***** 아래 코딩 잘보기 (중요한 소스코드, 쓰임이 자주있음)
		// 			=> 반대쪽에서 request를 받으려면 아래처럼해야함 직접 request의 객체를 가져와야한다
		//  		=> 컨트롤러가 없으면 모델없이 못가져옴
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		// request를 갖고들고오는 메소드들
		request.setAttribute("tList", list);
	}
	
}
