package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;
@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	// Request, Response 없이 받을 매개변수와, 전송객체(model)를 통해서 값을 주고 받는다
	@RequestMapping("food/list.do")
	public String food_list(String page,Model model) {
		// page는 처음에 null이기때문에 int 대신 String으로 받는다
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
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("list",list);
				
		return "food/list";
	}
	
	
	// String, int 등 변수유형 설정하면 자동으로 그 유형에 맞춰서 값을 주고받느다
	@RequestMapping("food/detail.do")
	public String food_detail(int fno,Model model) {
		// *** 반드시 사용자가 보내준 변수명과 매개변수명이 일치해야한다!!!
		// controller에서 parameterNames를 먼저 갖고오기때문에
		// 매개변수의 순서는 상관없음!
		FoodVO vo=dao.foodDetailData(fno);
		model.addAttribute("vo",vo);
		/*
		 		class Model
		 		{
		 			private HttpServletRequest request
		 			public Model(HttpServletRequest request)
		 			{
		 				this.request=request;
		 			}
		 			public void addAttribute(String key,Object obj)
		 			{
		 				request.setAttribute(key,obj)
		 			}
		 		}
		 		
		 		request를 쓰지않고 Model 인터페이스를 쓰는 이유
		 		=> 보안 => request를 쓰면 사용자의 ip를 알 수 있음
		 		
		 		request로 받아야하는 예외들 => 쿠키
		 */
		return "food/detail";
	}
	
	@RequestMapping("food/find.do")
	public String food_find() {
		
		
		return "food/find";
	}
}









