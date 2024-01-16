package com.sist.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.sist.spring.Student;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext app=new GenericXmlApplicationContext("app2.xml");
		Student s=(Student)app.getBean("std");
		// 실행하고 객체가 생성된 순간 init
		System.out.println("학번:"+s.getHakbun());
		System.out.println("이름:"+s.getName());
		System.out.println("국어:"+s.getKor());
		System.out.println("수학:"+s.getMath());
		System.out.println("영어:"+s.getEng());
		app.close();
		// 객체소멸되는 순간 destroy
		// close를 쓰고싶으면 genericXml에만 있는 기능
	}

}
