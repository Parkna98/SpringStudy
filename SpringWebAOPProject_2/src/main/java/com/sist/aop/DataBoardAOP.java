package com.sist.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 메모리할당을 해야하는 8가지 annotation 잘기억
/*
		@Component
		@Repository
		@Service
		@Controller
		@RestController
		@ControllerAdvice 
		@RestControllerAdvice
		@Configuration
 */
// @Aspect는 component-scan으로 메모리할당이 안되기때문에 혼자서는 안됨
// ===> 컴포넌

@Aspect
@Component
public class DataBoardAOP {

}
