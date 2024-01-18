package com.sist.main;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		SeoulDAO sDao=(SeoulDAO)app.getBean("sDao");
		GoodsDAO gDao=app.getBean("gDao",GoodsDAO.class);
		String[] stable= {"","seoul_location","seoul_nature","seoul_shop"};
		String[] gtable= {"","goods_all","goods_best","goods_special","goods_new"};
		
		
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("===== Menu =====");
			System.out.println("1.여행");
			System.out.println("2.상품");
			System.out.println("3.종료");
			System.out.println("=================");
			System.out.print("선택:");
			int index=scan.nextInt();
			if(index==1) {
				System.out.println("===== 서브메뉴 =====");
				System.out.println("1. 명소");
				System.out.println("2. 자연 & 관광");
				System.out.println("3. 쇼핑");
				System.out.println("===================");
				System.out.print("여행 선택:");
				int sno=scan.nextInt();
				String table_name=stable[sno];
				Map map=new HashMap();
				map.put("table_name", table_name);
				List<SeoulVO> sList=sDao.seoulListData(map);
				for(SeoulVO vo:sList) {
					System.out.println(vo.getNo()+"."+vo.getTitle());
				}
				System.out.println("========================================");
				System.out.print("상세보기 할 번호 입력:");
				int sdno=scan.nextInt();
				map.put("no", sdno);
				SeoulVO vo=sDao.seoulDetailData(map);
				System.out.println("여행지:"+vo.getTitle());
				System.out.println("소개:"+vo.getMsg());
				System.out.println("주소:"+vo.getAddress());
				
			}else if(index==2) {
				System.out.println("===== 서브메뉴 =====");
				System.out.println("1. 전체상품");
				System.out.println("2. 베스트상품");
				System.out.println("3. 특가상품");
				System.out.println("4. 신상품");
				System.out.println("===================");
				System.out.print("메뉴번호 입력:");
				int gno=scan.nextInt();
				String g=gtable[gno];
				Map gmap=new HashMap();
				gmap.put("table_name", g);
				List<GoodsVO> gList=gDao.goodsListData(gmap);
				for(GoodsVO vo:gList) {
					System.out.println(vo.getNo()+"."+vo.getName());
				}
				System.out.println("==============================");
				System.out.print("상세보기 할 번호 입력:");
				int gdno=scan.nextInt();
				gmap.put("no", gdno);
				GoodsVO gvo=gDao.goodsDetailData(gmap);
				System.out.println("===============================");
				System.out.println("상품명:"+gvo.getName());
				System.out.println("부제:"+gvo.getSub());
				System.out.println("가격:"+gvo.getPrice());
				System.out.println("할인:"+gvo.getDiscount()+"%");
			}else {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
	}

}
