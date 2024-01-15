package com.sist.spring3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 		1. 스프링은 프로젝트에 필요한 클래스를 모아서 관리
 							  =============== 컨테이너 (클래스관리자)
 			=> 경량 컨테이너
 			=> 단순한 연결관계를 가지고 있다
 			=> 라이브러리로 제공
 				=> Open Source
 				=> Core (클래스를 찾아주는 역할)
 				=> 컨테이너 클래스
 				   BeanFactory => core
 				   		ㅣ
 				   ApplicationContext => core / AOP (commons같은 테이블을 자동호출하는 기능)
 				   		ㅣ
 				   WebApplicationContext => 
 				   
 				컨테이너/컴포넌트
 				
 				컴포넌트 : 개발자가 만든 클래스 한개 (기능을 수행하는 클래스)
 						 => 컴포넌트 여러개를 묶어 관ㄹ => 컨테이너
 				
 				컨테이너의 역할
 				===========
 					1. 객체 생성 (컴포넌트) (스프링에서 생성하기 때문에 new를 거의 쓰지 않는다)
 								=> 예외 : new를 사용해야되는 클래스 
 									=> ~VO는 데이터형
 					2. 객체 변수의 초기화 => DI	
 					3. 객체 소멸
 					================== 객체의 생명주기
 					4. 객체를 찾아주는 역할 수행 (DL) (객체의 이름을 이용해서 찾아주는 방식)
 					
 					DL / DI => core
 					
 					Spring : 클래스 관리자 / 멤버변수 초기화 / 메소드 호출 / 생성자 매개변수
 										=====================================
 											ㅣ DI (Data Injection) (값주입) => XML이용
 											
 				1. 클래스 관리
 					=> 클래스 등록 => 찾기
 				========================== DL 
 				2. 객체 생성시에 필요한 변수 주입
 				========================== DI
 */
public class MainClass {
	public static void main(String[] args) {
		// 스프링에서 사용하는 default 폴더 / classpath
		// classpath => src/main/java
		// 1. XML 파싱
		// 2. 컨테이너 => XML 전송
		
		// XML 파싱 클래스
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		
		// 등록된 클래스를 모아서 관리하는 역할의 클래스 => 컨테이너
		// 객체 메모리 할당 => 등록
		/*
		 *  	class ApplicationContext
		 *  	{
		 *  		Map map=new HashMap();
		 *  		map.put("id명", Class,forName("class명")
		 *  
		 *  		public Object getBean(String key)
		 *  		{
		 *				return map(key)  
		 *  		}
		 *  
		 *  	}
		 */
		// 객체 찾기 => DL
		Board board=(Board)app.getBean("board");
		System.out.println("board="+board);
		board.board_list();
		
		Board board1=(Board)app.getBean("board");
		System.out.println("board1="+board1);
		board1.board_list();
		
		Board board2=(Board)app.getBean("board");
		System.out.println("board2="+board2);
		board2.board_list();
		/*
		 *  기본 scope가 singleton이기 때문에 주소값 같음
		 *  사원정보등록같은 경우 각자 다른 메모리를 할당해서 다른 값을 등록해야 되긴 때문에
		 *  scope=prototype으로 지정
		 */
		Member member=(Member)app.getBean("member");
		member.member_insert();
		
		Notice notice=(Notice)app.getBean("notice");
		notice.notice_list();
	}
}
