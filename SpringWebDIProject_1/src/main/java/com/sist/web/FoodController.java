package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@RequestMapping("food/list.do")
	public String food_list(HttpServletRequest request, HttpServletResponse response) {
		
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=(rowSize*curpage);
		List<FoodVO> list=dao.foodListData(start, end);
		int totalpage=dao.foodTotalPage();
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		
		return "list";
		// .jsp를 default로 붙이기때문에 => food/list 까지만 리턴한다
		// http://localhost:8080/web/food/list.do 
		// web이 패키지 이름임 => 프로젝트 생성시에 디폴트 패키지 => com.sist.web => /web 으로 읽고 들어옴
		// com.sist.main으로 만들면 /main/food.
		
		// 톰캣서버 돌릴때 항상 removeall 로 다 지우고 실행한다 => why?
		
		// dispatcher가 실행안되는거같으면 경로 먼저 확인 webapp에 jsp폴더가 있어야하고
		// WEB-INF 밑에 config폴더 - 그밑에 application-*.xml이 있어야한다
		// 경로가 맞으면, 파일명으로 찾기때문에 파일명에 오타가 없는지 확인한다
		
	}
}
