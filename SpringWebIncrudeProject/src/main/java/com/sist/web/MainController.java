package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.FoodVO;
/*
		1. MVC 동작
			=> web.xml에 DispatcherServlet
							= HandlerMapping : @Controller
							= WebApplicationContext : 클래스 관리
								=> @Autowired => getBean()을 쓸순있지만 Autowired가 간편,효율적
		
		2. 공통 에외처리 : @ControllerAdvice
		
		3. 인터셉트 사용 : preHandle(), afterCompletion()
		
		4. 메모리 할당 : Annotation
		
		5. AOP 
		
		6. Cookie / HttpSesiion
		
		7. RestController => JSON
			
		==> 면접 Q. DI / AOP / MVC
		==> JSON, Rest ...
			
		============================================================ 기본과정
		6. 고급
			Validation, WebSocket, Security, Task(Betch)
			Spring-Data
 */
@Controller
public class MainController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("main/main.do")
	public String main_main(String page,Model model) {
		
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=(curpage*rowSize);
		
		List<FoodVO> list=dao.foodListData(start, end);
		int totalpage=dao.foodTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("list",list);
		model.addAttribute("main_jsp","home.jsp");
		return "main/main";
	}
}
