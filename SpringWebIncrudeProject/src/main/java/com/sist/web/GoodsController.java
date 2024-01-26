package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;
	@Autowired
	private GoodsReplyDAO rdao;
	
	String[] tab= {"","goods_all","goods_best","goods_special","goods_new"};
	
	@GetMapping("goods/list.do")
	public String goods_list(String page,int type,Model model) {
		
		if(page==null)
			page="1";
		String tab_name=tab[type];
		int curpage=Integer.parseInt(page);
		int totalpage=dao.goodsAllTotalPage(tab_name);
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=(rowSize*curpage);
		
		List<GoodsVO> list=dao.goodsAllListData(start, end, tab_name);
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
		model.addAttribute("type",type);
		
		model.addAttribute("main_jsp","../goods/list.jsp");
		return "main/main";
	}
	
	@GetMapping("goods/detail_before.do")
	public String goodsAll_detail_before(int no,int type,HttpServletResponse response,RedirectAttributes ra) {
		
		Cookie cookie=new Cookie("goods_"+no, String.valueOf(no));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		ra.addAttribute("no",no);
		ra.addAttribute("type",type);
		return "redirect:../goods/detail.do";
		
	}
	
	@GetMapping("goods/detail.do")
	public String goodsAll_detail(int no,int type,Model model) {
		String tab_name=tab[type];
		GoodsVO vo=dao.goodsAllDetailData(no,tab_name);
		
		Map map=new HashMap();
		map.put("gno", no);
		map.put("type", type);
		List<GoodsReplyVO> rList=rdao.goodsReplyListData(map);
		
		model.addAttribute("vo",vo);
		model.addAttribute("rList", rList);
		model.addAttribute("main_jsp","../goods/detail.jsp");
		model.addAttribute("type",type);
		return "main/main";
	}
	
	@RequestMapping("goods/find.do")
	public String goods_find(String page,String type,String ss,Model model) {
		if(page==null)
			page="1";
		if(type==null)
			type="1";
		if(ss==null)
			ss="한우";
		
		String tab_name=tab[Integer.parseInt(type)];
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=(rowSize*curpage);
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("tab_name", tab_name);
		map.put("ss", ss);
		
		int totalpage=dao.goodsAllFindTotalPage(map);
		if(endPage>totalpage)
			endPage=totalpage;
		
		List<GoodsVO> list=dao.goodsAllFindListData(map);
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("type", type);
		model.addAttribute("ss", ss);
		
		model.addAttribute("main_jsp","../goods/find.jsp");
		return "main/main";
	}
	
	@PostMapping("goods/reply_insert.do")
	public String goods_reply_insert(int gno,int type,String msg,HttpSession session,RedirectAttributes ra) {
		GoodsReplyVO vo=new GoodsReplyVO();
		vo.setGno(gno);
		vo.setType(type);
		vo.setMsg(msg);
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("name");
		vo.setId(id);
		vo.setName(name);
		rdao.goodsReplyInsert(vo);
		
		ra.addAttribute("no",gno);
		ra.addAttribute("type",type);
		
		
		
		return "redirect:../goods/detail.do";
	}
	
	@PostMapping("goods/reply_update.do")
	public String goods_reply_update(int gno, int no, int type, String msg, RedirectAttributes ra) {
		GoodsReplyVO vo=new GoodsReplyVO();
		vo.setMsg(msg);
		vo.setNo(no);
		rdao.goodsReplyUpdate(vo);
		
		ra.addAttribute("no",gno);
		ra.addAttribute("type",type);
		
		return "redirect:../goods/detail.do";
	}
	
	@GetMapping("goods/reply_delete.do")
	public String goods_reply_delete(int gno, int no, int type, RedirectAttributes ra) {
		rdao.goodsReplyDelete(no);
		
		ra.addAttribute("no",gno);
		ra.addAttribute("type",type);
		
		return "redirect:../goods/detail.do";
	}
	
	
}
