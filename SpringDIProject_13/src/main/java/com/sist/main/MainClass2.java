package com.sist.main;
import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.dao.*;
import com.sist.config.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(EmpConfig.class); 
		// .class => 매개변수가 class이기떄문에 컴파일된 클래스파일을 대입하기 위함
		EmpDAO dao=(EmpDAO)app.getBean("empDAO");
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getSal());
		}
	}

}
