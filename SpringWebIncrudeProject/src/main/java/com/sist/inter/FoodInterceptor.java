package com.sist.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*
 * 
 						FrontController : 요청받기 => 응답
		main.do ======> DispatcherServlet ======> HandlerMapping : Model 찾기
													ㅣ @GetMapping / @PostMapping => 기능 수행 
													  ============================     Back-End
								ㅣ					  프로그래머 (Model) 찾기
								ㅣ					  Model (스프링에서는 Controller, 스트럭쳐는 action)					
								ㅣ						1) VO					
								ㅣ						2) DAO
								ㅣ						3) Manager
								ㅣ						4) Service
								ㅣ						=> 유지보수의 용이를 위함 (역할분담)
								ㅣ						
								ㅣ
								ㅣ				=> @GetMapping("main.do")
								ㅣ					ㅣ
								ㅣ					return "main/main";
								ㅣ					ㅣ ---> postHandle
								ㅣ					ViewResolver
								ㅣ					ㅣ request
								ㅣ					ㅣ ---> afterCompletion
								ㅣ					JSP - Front-End
								ㅣ
								ㅣ
							preHandle
							(HandlerMapping이 Mapping을 찾기전에 가로챈다 (intercept) )
							( ===> ex) 자동로그인 => main.do를 찾기전에 preHandle에서 자동로그인을 해버린다)
							
		
 */
// <bean> 태그 이용 => Login 처리시 주로 이용
public class FoodInterceptor extends HandlerInterceptorAdapter{

	// request,response가 있으므로 쿠키가 있다던지 등등의 기능을 수행할 수 있다
	@Override
	// main.do 찾기전 (모델 수행전 : ex 자동로그인, id저장)
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("======== preHandle() Call... =========");
		return super.preHandle(request, response, handler);
	}

	@Override
	// ViewResolver로 넘어가기전 
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("======== postHandle() Call... ========");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	// JSP로 넘어가기 전
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("========= afterCompletion =========");
		super.afterCompletion(request, response, handler, ex);
	}
	
}
