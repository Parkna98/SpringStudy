package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.DeptDAO;
import com.sist.dao.DeptVO;
import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;
/*
 *  DI => 넓은 의미 : 클래스 간의 연결을 하는 것 
 *  	  좁은 의미 : 값을 주입한다 (setter...)
 *  
 *  IOC => Inversion of Controller 
 *  (DI라는 명칭 등장 전에 사용하던 명칭)
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getHiredate().toString()+" "
					+vo.getSal());
		}
		
		System.out.println("========================");
		Scanner scan=new Scanner(System.in);
		System.out.print("사번 입력:");
		int empno=scan.nextInt();
		EmpVO vo=dao.empDetailData(empno);
		System.out.println(vo.getEmpno()+" "
				+vo.getEname()+" "
				+vo.getJob()+" "
				+vo.getHiredate().toString()+" "
				+vo.getSal());
		

		/*System.out.println("========================");
		DeptDAO dao=(DeptDAO)app.getBean("dao2");
		List<DeptVO> list=dao.deptListData();
		for(DeptVO vo:list) {
			System.out.println(vo.getDeptno()+" "
					+vo.getDname()+" "
					+vo.getLoc());
		}*/
	}

}
