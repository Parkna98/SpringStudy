package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.spring.Member;
import com.sist.spring.Sawon;

// 스프링이 관리하는 클래스가 아니다 => 스프링에 등록하지 않았기 때문
public class MainClass {
	public static void main(String[] args) {
		// ApplicationContext => Container  (클래스로 만들어져있음)
		ApplicationContext app=new ClassPathXmlApplicationContext("application1.xml");
		Sawon s=(Sawon)app.getBean("sa");
		// sa=new Sawon()
		System.out.println("사번:"+s.getSabun());
		System.out.println("이름:"+s.getName());
		System.out.println("성별:"+s.getSex());
		
		Member m=(Member)app.getBean("mem");
		m.print();
		Member m1=(Member)app.getBean("mem1");
		m1.print();
		Member m2=(Member)app.getBean("mem2");
		m2.print();
	}
}
