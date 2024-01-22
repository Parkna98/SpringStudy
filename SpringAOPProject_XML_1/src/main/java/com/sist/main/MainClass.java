package com.sist.main;
/*
 		1. Container
 			ApplicationContext => Map
 			AnnotationConfigApplicationContext
 			WebApplicationContext
 			=> 객체 생성 / 주입 / 소멸 => XML,Annotation
 			
 		2. DI (Dependency Injection)
 			=> 객체 생성시에 멤버변수의 초기ㅗ하
 			
 		3. AOP => 반복제거
 		=============================================
 		=====> 라이브러리
 */
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list=dao.empListData();
		/*for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getDbday()+" "
					+vo.getSal());
		}*/
		
	}

}
