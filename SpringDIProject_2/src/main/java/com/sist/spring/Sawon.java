package com.sist.spring;
/*
		스프링은 오픈 소스 라이브러리 => 확장성 (변경해서 사용이 가능)
					  =================================
					  프레임워크 (스프링 => 전자정부 프레임워크)
					  				=> ANY 프레임워크
		
		지원하는 라이브러리 
		==============
		Core :  1. bean => 객체 생성 ~ 객체 소멸
			   		<bean> : 클래스 한개
			   		<context:component-scan> : 패키지 단위로 등록 (*)
			   			=> 선택적 => Annotation (있으면 메모리할당, 없으면 X)
			   	
			   	2. 순수하게 자바만 이용 => @Bean
			   	=====================================================
			   	
		Data Access : JDBC / ORM(MyBatis,JPA) / JMS / OXM 
					  ======================= Transaction
					  
		Web : Web / MVC 
		AOP : 공통 모듈 => Commons ~ 
				=> Transaction / Security => (AOP 기반)
				
		스프링 => 클래스 관리자 (프로그램에 맞게 만든 클래스를 관리)
				사용자 정의 클래스 / 라이브러리 클래스
				=====================================
				 => 컨테이너
				 
		컨테이너 => 객체를 저장하는 공간
		 	   => 객체의 생명주기를 담당 (생성 / 소멸)
		 	   
		스프링에서 지원하는 컨테이너
		--------------------
			BeanFactory
				ㅣ
			ApplicationContext
			   	ㅣ
		-------------------------------------------------------------------------
		ㅣ									ㅣ									ㅣ			
	 GenericXmlApplicationContext		AnnotationConfigApplicationContext	  WebApplicationContext
	   => close()  : Application		  => XML없이 사용
	   => 클래스가 많은 경우/연결관계가 많은 경우	
	   => 자바전용이 아니다 (코틀린 등등)
	   
	 ==========================> 실무 
	 							 사용자 정의 클래스 => 어노테이션
	 							 라이브러리 클래스 => 공통(XML)
	 ======================================================
	 	스프링 프레임워크의 특징
	 	1. 경량 컨테이너 
	 		: Spring에서 객체 생성 => 소멸을 담당
	 			= DL => 클래스 찾기 => getBean()
	 			= DI => 객체 생성시에 멤버변수의 초기값이 필요한 경우
	 					=> 자동 로그인, 데이터베이스 처리
	 					=> setterDI (set 메소드에 값넣기), 생성자 DI (생성자에 값넣기)
	 					=> getterDI
	 					
	 	2. *** POJO 방식을 사용 => 스프링 2.5버전
	 	  (Plain Old Java Object)
	 	  특정 프레임 워크 기술에 의존하지 않는다
	 	  Plain : 상속되지 않는 클래스 => 독립적, 다른 클래스에 영향을 미치지 않는다 => 분업에 좋다
	 	 => OLD => 일반 자바
	 	 => 느슨한 결합 (lose coupling) => 한번 거쳐가는 식으로, 에러가 사용자에게 보이지 않도록 그전에 띄우기
	 	 
	 	3. 유지보수 : 클래스가 독립적으로 저장
	 	
	 	4. 확장성
	 	
	 	5. 필요한 모든 라이브러리를 지원한다 (ex. Kafka)...
	 		개념을 잘 정리해놓자!!
	    ==================================================================================
	    1. DI (***)
	    2. DL
	    3. AOP (***)
	    ==================================================================================
	    4. DataBase (ORM)
	    5. Transaction (***)
	    6. Web (MVC) (***)
	    7. Security
	    ==================================================================================
	 		DI => 스프링을 통해서 멤버변수의 초기화
	 			  객체 생성
	 	
	 	컨테이너가 setter에 값을 투자
	 	bean 태그 => 객체가 저장되고 생성
	 	p: => 객체에 값을 줌
	 	
	 	스프링에서 읽어와서 메모리할당이 가능한 것 : xml, annotation
	 		=> 라이브러리는 자바 소스를 추가할 수 없다
	 			=> 라이브러리에서 읽어가는 파일 생성 ***
	 						 ===========
	 						 1. XML
	 						 	=> 태그명 / 속성명이 다르면 인식을 못한단ㄷ
	 						 2. Annotation이 있는 클래스
	 						 	=> 스프링에서 지원하는 Annotation만 이용한다 ( ex) @AutoWired @RequestMapping ...)
	 						 	
	 						 ( 1) XML만 쓸때, 2) Annotation만 쓸때, 3) 두개 혼용)
	 	
 */
// 스프링에서 관리하는 클래스 (VO제외)
public class Sawon {
	// 1. Setter DI
		private int sabun;
		private String name;
		private String sex;
		public int getSabun() {
			return sabun;
		}
		public void setSabun(int sabun) {
			this.sabun = sabun;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
	
	
	
	
	
}
