package com.sist.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FoodController {
	@GetMapping("food/detail_before.do")
	public String food_detail_before(int fno,HttpServletResponse response,RedirectAttributes ra) {
		// 값을 받을때는 HttpRequest, 쿠키를 전송해야하므로 response를 쓴다!!
		
		Cookie cookie=new Cookie("food_"+fno, String.valueOf(fno));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		ra.addAttribute("fno",fno);
		// 물음표로 보내지않고, 매개변수에 RedirectAttributes 인터페이스를 활용해 값을 보낸다
		// ra.addFlashAttribute(null, ra); // 감춰서 보내는 Flashattribute
		return "redirect:../food/detail.do";
	}
}
