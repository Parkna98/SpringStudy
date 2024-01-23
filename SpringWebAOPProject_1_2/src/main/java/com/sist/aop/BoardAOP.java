package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.dao.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
@Aspect
@Component
public class BoardAOP {
	@Autowired
    private BoardDAO dao;
	
	@After("execution(* com.sist.web.*Controller.*(..))")
	public void after()
	{
		List<BoardVO> list=dao.boardTop5();
		// 실제 사용중인 request를 가지고 올때 사용 => Cookie
		HttpServletRequest request=
				((ServletRequestAttributes)
						RequestContextHolder.getRequestAttributes())
				        .getRequest();
		request.setAttribute("tList", list);
	}
}
