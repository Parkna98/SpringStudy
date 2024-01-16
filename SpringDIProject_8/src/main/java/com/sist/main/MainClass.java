package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		SeoulDAO dao=(SeoulDAO)app.getBean("dao");
		
		List<SeoulVO> list=dao.shopListData();
		for(SeoulVO vo:list) {
			System.out.println(vo.getNo()+"."+vo.getTitle());
		}
		
		System.out.println("=============");
		Scanner scan= new Scanner(System.in);
		System.out.print("번호 입력:");
		int no=scan.nextInt();
		SeoulVO vo=dao.shopDetailData(no);
		System.out.println("번호:"+vo.getNo());
		System.out.println("장소:"+vo.getTitle());
		System.out.println("주소:"+vo.getAddress());
		System.out.println("소개:"+vo.getMsg());
		
		System.out.println("=============");
		System.out.print("검색어 입력:");
		String fd=scan.next();
		List<SeoulVO> slist=dao.shopFindData(fd);
		for(SeoulVO vo1:slist) {
			System.out.println(vo1.getNo()+" "
					+vo1.getTitle());
		}
	}

}
