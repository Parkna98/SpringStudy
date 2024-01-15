package com.sist.spring1;
/*
 * 		MainClass는 Hello클래스에 의존한다
 * 		=> 결합성이 강한 프로그램 => 단점 : 유지보수가 어렵다
 * 		=> 상호 연결이 어렵다
 * 		=> 가급적이면 new를 사용하지 않는다
 * 
 * 		=> 스프링의 장점 : 독립성
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello hello=new Hello();
		hello.sayHello("홍길동");
	}

}
