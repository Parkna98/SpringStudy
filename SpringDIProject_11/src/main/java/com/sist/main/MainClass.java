package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;

@Component
/*
 * 		커서 가져다 대면 target이 나온다!
 * 
		@Component => {TYPE}
			=> 사용위치 ==> 클래스에만 적용
		
		@Autowired => {CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE} => 클래스위에는 적용불가
						  생성자		 메소드	 매개변수	   멤버변수	  어노테이션
		
		class A
		{	
			@
			B b
			@
			public A(){}
			@
			public void display(){}
			public A(@ B b){}
		}
 */
public class MainClass { 
	
	@Autowired // Autowired는 객체선택을 하지 못한다
	@Qualifier("foodDAO") // 인터페이스를 사용하는 repository가 2개이상이면 qualifier을 사용해서 특정시킨다!!
	private OracleDB ob;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		// getBean을 사용하지 않고 new로 새로 메모리할당하면 ob는 null값이라 오류난다
		// Spring에서 메모리할당한 것을 getBean을 사용해야한다!!
		mc.ob.display();
	}

}
