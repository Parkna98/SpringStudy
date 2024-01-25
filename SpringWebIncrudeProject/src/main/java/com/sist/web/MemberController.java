package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import com.sist.vo.MemberVO;
@Controller
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@GetMapping("member/login.do")
	public String member_login() {
		
		return "member/login";
	}
	
	@PostMapping("member/login_ok.do")
	public String member_login_ok(String id,String pwd,Model model,HttpSession session) {
		
		MemberVO svo=new MemberVO();
		svo.setId(id);
		svo.setPwd(pwd);
		MemberVO vo=dao.memberLogin(svo);
		model.addAttribute("msg",vo.getMsg());
		// 로그인 성공시 request를 가져와서 session을 저장하는것이 아니라
		// session을 매개변수로 가져와서 session에다가 저장한다
		if(vo.getMsg().equals("OK")) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
		}
		
		return "member/login_ok";
	}
	
	// Post인데 Get을 썼을 경우 => 405 Error
	/*
	 *  	1. 500 Error => 자바 소스 에러
	 *  	2. 404 Error => 파일이 없는 경우
	 *  	3. 405 Error => GET/POST 에러
	 *  	4. 400 Error => Bad request => 주고 받는 데이터형 오류 (매개변수 확인)
	 *  	5. 412 Error => 한글변환코드 에러
	 *      				UFT-8(X) UTF-8(O)
	 */
	
	@PostMapping("member/logout.do")
	public String member_logout(HttpSession session) {
		session.invalidate();
		
		
		return "redirect:../main/main.do";
	}
	
}
