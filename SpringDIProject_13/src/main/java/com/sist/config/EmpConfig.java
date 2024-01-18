package com.sist.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// Spring5버전 => xml태그대신 java로 코딩
/*
 * 		java로 코딩하는게 xml보다 보안이 더 좋음
 * 		java는 컴파일된 .class파일로 넘기면되고 
 * 		xml은 컴파일되지않고 통째로 넘겨야되기때문에 java의 보안이 더좋다
 */

@Configuration
// <context:component-scan base-package="com.sist.*"></context:component-scan>
@ComponentScan(basePackages = "com.sist.*")
public class EmpConfig {
	/*
	 * <bean id="ds" 
		class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="oracle.jdbc.driver.OracleDriver"
		p:url="jdbc:oracle:thin:@localhost:1521:XE"
		p:username="hr"
		p:password="happy"
		/>
	 */
	
	@Bean("ds")
	public BasicDataSource dataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	/*
	 * <bean id="ssf"
		class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds"
		/>
	 */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	/*
	 * 	<bean id="mapper"
		class="org.mybatis.spring.mapper.MapperFactoryBean"
		p:sqlSessionFactory-ref="ssf"
		p:mapperInterface="com.sist.mapper.EmpMapper"
		/>
	 */
	
	@Bean("mapper")
	public MapperFactoryBean mapperFactoryBean() throws Exception{
		MapperFactoryBean mapper=new MapperFactoryBean();
		mapper.setSqlSessionFactory(sqlSessionFactory());
		mapper.setMapperInterface(com.sist.mapper.EmpMapper.class);
		return mapper;
	}
	
	
}
