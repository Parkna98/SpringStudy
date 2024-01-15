package com.sist.spring2;
/*
 * 		인터페이스를 이용하면 결합성이 new보다는 낮다
 * 		=> 인터페이스의 단점 : 인터페이스를 수정하면 모든 클래스에 에러발생
 * 		=> SW => 인터페이스는 고정
 * 				 ======= default
 * 		
 */
public class HelloImpl implements Hello{

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println(name+"님 환영합니다!!");
	}
	
}
