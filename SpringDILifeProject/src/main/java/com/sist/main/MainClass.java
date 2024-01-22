package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 		DI 생명주기
 			1. 컨테이너 생성 => ApplicationContext
 			2. XML/Annotation => 빈생성 (객체 생성) => 어떤 객체 생성
 			   VO, MainClass => 제외
 			3. 주입 (setter, constructor)
 			4. 초기화 콜백 => init-method 
 			5. 프로그래머가 사용
 			6. 소멸 => 콜백함수 호출 => destroy-method 
 			7. spring 종료 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericApplicationContext app=new GenericXmlApplicationContext("app.xml");
		Sawon sa=(Sawon)app.getBean("sa");
		sa.print();	
		app.close();
		/*
		 *  setDept() Call...
			setName() Call...
			setSabun() Call...
			빈 이름 설정 => Map에 저장
			setter설정 완료
			=== 사원 정보 ===
			사번:1
			이름:홍길동
			부서:개발부
			=== 객체 소멸 ===
		 */
	}

}
