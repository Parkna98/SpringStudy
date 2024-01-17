package com.sist.ann;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds"
	/>
 */

@Component("ssf") // 아이디 설정
// 안쓰면 클래스명이 아이디명이됨(앞에만 소문자로 바뀌어서) => mysQlSessionFactoryBean
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{

	@Autowired   // DataSource를 찾아서 값을 대입해줌 => 자동 getBean
	// => 값받을땐 Autowired
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}
	
}
