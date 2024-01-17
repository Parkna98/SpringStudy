package com.sist.main;
// @Autowired : 반드시 스프링에서 메모리 할당을 해야 자동 주입이 가능
	/*
	 class A{
		 @Autowired 
		 B b; ==> null
	 }class B{
		 @Compononet
		 	class B{
			 @Autowired
		 }
		 
		 ** 스프링에 값을 전달해줘야 메모리 할당된다
		 	메모리 할당 후 값 넣기
		 
		 */

import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		FoodDAO fDao=(FoodDAO)app.getBean("fDao");
		GoodsDAO gDao=(GoodsDAO)app.getBean("gDao");
		Scanner scan=new Scanner(System.in);
		/*System.out.print("1.업체명, 2.주소, 3.음식종류 선택:");
		int col=scan.nextInt();
		String fd="";
		String[] temp= {"","name","address","type"};
		fd=temp[col];
		System.out.print("검색어 입력:");
		String ss=scan.next();
		
		Map map=new HashedMap();
		map.put("col_name", fd);
		map.put("ss", ss);
		
		List<FoodVO> list=fDao.foodFindData(map);
		for(FoodVO vo:list) {
			System.out.println(vo.getFno()+" "
							+vo.getName()+" "
							+vo.getAddress()+" "
							+vo.getType());
		}*/
		
		System.out.print("상품명 검색:");
		String sss=scan.next();
		List<GoodsVO> list=gDao.goodsFindData(sss);
		for(GoodsVO vo:list) {
			System.out.println(vo.getNo()+"."+vo.getGoods_name()+" "+vo.getGoods_price());
		}
				
	}

}
