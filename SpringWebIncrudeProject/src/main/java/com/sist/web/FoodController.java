package com.sist.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.FoodVO;
/*
		RedirectAttributes
		Model
		
		MVC => 화면 변경
				1. request를 전송 => forward
					=> 값을 전송 : Model(인터페이스) 이용 (request가 내장되어있음)
					return "main/main";
				2. 재사용 / 재호출 => sendRedirect
					=> 값을 전송 : RedirectAttributes 이용
					return "redirect:~~.do"
					
		Model(Controller)
			1) 형식
				= 리턴형
					String(이동할 페이지), void
				= 매개변수 
					요청값 받기
					String, 일반데이터형 (int...)
					VO 
					내장객체
					스프링 지원 객체
					================= 매개변수의 순서는 상관없다 (변수명은 일치해야함)
					=> ?no=1 ==> (int no)
					=> <input type=text name=name> ==> (String name)
					
					=> ?no=1&type=2 ==> (int no,int type)
					
				@GetMapping
					=> <a>, sendRedirect, location.href, axios.get()
				@PostMapping
					=> form, ajax(type='post'), axios.post() ...
				@RequestMapping => GET & POST
 */
import com.sist.vo.ReplyVO;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	@Autowired
	private ReplyDAO rdao;
	@GetMapping("food/detail_before.do")
	public String food_detail_before(int fno,HttpServletResponse response,RedirectAttributes ra) {
		// 값을 받을때는 HttpRequest, 쿠키를 전송해야하므로 response를 쓴다!!
		
		// 쿠키는 일반 객체 => 매개변수로 받을 수 없음
		Cookie cookie=new Cookie("food_"+fno, String.valueOf(fno));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		// sendRedirect => 값 전송
		ra.addAttribute("fno",fno);
		// 물음표로 보내지않고, 매개변수에 RedirectAttributes 인터페이스를 활용해 값을 보낸다
		// ra.addFlashAttribute(null, ra); // 감춰서 보내는 Flashattribute
		return "redirect:../food/detail.do";
	}
	
	@GetMapping("food/detail.do")
	public String food_detail(int fno,Model model) {
		FoodVO vo=dao.foodDetailData(fno);
		List<ReplyVO> rList=rdao.replyListData(fno);
		model.addAttribute("rList",rList);
		model.addAttribute("vo",vo);
		model.addAttribute("main_jsp","../food/detail.jsp");
		return "main/main";
	}
	
	@RequestMapping("food/find.do")
	public String food_find(String col_name,String ss,String page,Model model) {
		if(col_name==null)
			col_name="type";
		if(ss==null)
			ss="한식";
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=(curpage*rowSize);
		
		Map map=new HashMap();
		map.put("col_name", col_name);
		map.put("ss", ss);
		map.put("start", start);
		map.put("end", end);
		
		List<FoodVO> list=dao.foodFindListData(map);
		int totalpage=dao.foodFindTotalPage(map);
		
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
		model.addAttribute("ss",ss);
		model.addAttribute("col_name",col_name);
		
		model.addAttribute("main_jsp","../food/find.jsp");
		return "main/main";
	}
}
