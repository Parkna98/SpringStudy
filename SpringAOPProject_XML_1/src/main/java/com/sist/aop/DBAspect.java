package com.sist.aop;
import com.sist.dao.*;
import java.util.*;

import org.aspectj.lang.ProceedingJoinPoint;
// DI => Injection => setter, 생성자
// DI => 클래스와 클래스의 연결관계설정
/*
		aspect : 공통으로 사용되는 기능을 모아서 관리 : 공통모듈
		Advice 
		======
		  PointCut  => 어떤 메소드에 적용
		  JoinPoint => 위치
		  	= Before => 메소드 시작 전
		  	= After => finally
		  	= AfterThrowing => catch(오류발생)
		  	= AfterReturning => return(정상수행)
		  	= Around => 전후
		  	============ Around
		  	   소스코드
		  	============ Around
		========================================
		통합해서 새로운 기능을 만든다 (위빙 => Weaving) => Proxy패턴 (대리자)
		PointCut : 어떤 메소드에 적용 여부
			execution( *   패키지명.클래스명.*() )
					   ==              == == 매개변수없음 / (String) / (String,int) / (..) => 매개변수 상관없음
					   리턴형			메소드의 패턴 (emp* => emp로 시작하는 모든 메소드)
					   
					   => 모든 패키지에 있는 모든 클래스에 적용
					   		=> 로그
					   			within("패키지명.*")
					   			
					   => 모든 모델 클래스 => * 패키지명.*Controller.*(..)
		  	
 */
public class DBAspect {
	private EmpDAO dao;
	// setter만 나오는 이유 => spring에서 값을 할당하고 그값을 가져오기위해
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	// try 진입전
	public void before() {
		dao.getConnection();
	}
	// finally
	public void after() {
		dao.disConnection();
	}
	
	// Before, After
	// 데이터 출력 => After-Returning 
	public void afterReturning(Object obj) {
		System.out.println("===== 결과값 자동 처리 =====");
		List<EmpVO> list=(List<EmpVO>)obj;
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getDbday()+" "
					+vo.getSal());
		}
	}
	// 에러 => After-Throwing => catch
	public void afterThrowing(Throwable ex) {
		System.out.println("======= 에러발생 =======");
		ex.printStackTrace();
		// Web => ControllerAdvice : 공통 예외처리
	}
	
	// 시간 => Around => 트랜잭션 / 보안(이미 AOP로 제작되어있음) / 로그
	// 사용자 정의 AOP는 보통 아래의 시간체크 정도할때만 만들고 자주쓰이는것은 만들어져있다
	public Object around(ProceedingJoinPoint jp) throws Throwable{
		Object obj=null;
		long start=System.currentTimeMillis();
		System.out.println("호출된 메소드:"+jp.getSignature().getName());
		// 사용자가 호출한 메소드
		// 메소드 호출
		obj=jp.proceed(); // dao.empListData() => invoke()
		long end=System.currentTimeMillis();
		System.out.println("수행시간:"+(end-start));	
		
		return obj;
	}
}
