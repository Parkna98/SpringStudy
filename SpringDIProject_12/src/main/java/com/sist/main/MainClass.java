package com.sist.main;


/*
		Annotation 
			= 메모리 할당 (선택적)
				=> 스프링에서 기능별로 구분해서 사용
				@Component : 일반 클래스 => ~Manager, MainClass
				@Repository : 저장소 => ~DAO 
				@Service : DAO여러개를 연결해서 사용, BI
						   => 기능을 통합해서 사용
						   => 실무에서는 주로 사용
						   => ~Service (클래스이름 생성시에 보통 Service를 덧붙임 ex) ~DAO, ~VO)
				@Controller : Model (스트럿츠: ~Action)
								=> ex) BoardController, StayController
								=> 페이지 이동 등
				@RestController : Model => 자바스크립트와 연결
					=> JSON이나 문자열 넘길때 사용 
					=> VueJS 사용 시 자주 등장
				
				@ControllerAdvice : 모든 Model클래스의 예외처리
				
				@Configuration : application.xml을 자바로 설정
				
				잘모르겠으면 @Comonent써도 무방 => 위의 Annotataion모두 Component 상속받는중
				
				
			= DI 
				@Autowired => 스프링에 의해서 자동으로 객체주소를 주입
				@PostConstructor => init-method
				@PreDestroy => destroy-method
				
		
 */
@Component
class A{
	public void display() {
		System.out.println("A:display Call");
	}
}
class B{
	public void display() {
		System.out.println("B:display Call");
	}
}
@Component
class C{
	public void display() {
		System.out.println("C:display Call");
	}
}

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cls= {"com.sist.main.A",
				"com.sist.main.B",
				"com.sist.main.C"};
		try {
			for(String s:cls) {
				Class clsName=Class.forName(s);
				if(clsName.isAnnotationPresent(Component.class)==false) {
					continue;
				}
				Object obj=clsName.getDeclaredConstructor().newInstance();
				System.out.println(obj);
			}
		}catch(Exception ex) {}
		
	}

}
