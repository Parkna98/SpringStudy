package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
/*
 		어노테이션 : 구분자
 		=======
 		1. 메모리 할당 요청 (선택적 어노테이션) => 클래스별 구분 
 			==> StereoType(스테레오 타입)
 			@Component
 				ㅣ
 			----------------------------------------------------------
 			ㅣ			ㅣ			ㅣ			ㅣ					ㅣ
 		@Repository	  @Service   @Controller  @RestController	@ControllerAdvice/RestControllerAdvice
 			=> DAO		=> BI		=> Model	=> Vue/React		=> 공통으로 한번에 모아서 예외처리
 						(DAO여러개)	(파일명 보내기)	   (값 보내기)	
 		
 		2. DI(주입)
 			@Autowired : 자동 주입
 			@Inject
 			
 		3. AOP : 공통모듈
 			@Aspect => @Before, @After ...
 */
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	public List<FoodVO> foodListData(int start, int end){
		return mapper.foodListData(start, end);
	}
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
}	













