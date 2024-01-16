package com.sist.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.spring.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// xml 동시에 두개이상 읽기 => 1. 배열이용 2. 패턴주기 (*)
		/*String[] xml= {"application-board.xml","application-notice.xml"};*/
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		// application-* => application- 로 시작하는 모든 xml파일
		
		
		Board b=app.getBean("board",Board.class);
		System.out.println("번호:"+b.getNo());
		System.out.println("이름:"+b.getName());
		System.out.println("제목:"+b.getSubject());
		
		Notice n=app.getBean("notice",Notice.class);
		System.out.println("번호:"+n.getNo());
		System.out.println("이름:"+n.getName());
		System.out.println("제목:"+n.getContent());
		
	}

}
