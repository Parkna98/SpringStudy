package com.sist.aop;
import java.util.*;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.dao.*;

@Aspect
@Component
public class BoardAOP {
	@Autowired
	private BoardDAO dao;
}
