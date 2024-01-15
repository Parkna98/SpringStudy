package com.sist.main;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="C:\\springDev\\springStudy\\SpringContainerProject\\src\\main\\java\\com\\sist\\main\\app.xml";
		ApplicationContext app=new ApplicationContext(path);
		Board board=(Board)app.getBean("board");
		System.out.println(board);
		board.board_list();
			
		Board board1=(Board)app.getBean("board");
		System.out.println(board1);
		board1.board_list();
		
		Board board2=(Board)app.getBean("board");
		System.out.println(board2);
		board2.board_list();
		
		/*
		 *  	독립적으로 만든 자바 (상속, 인터페이스 등 아무것도 없는)
		 *  	=> POJO class
		 */
		
	}

}
