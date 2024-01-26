package com.sist.vo;

import java.util.Date;

import lombok.Data;
@Data
public class ReplyVO {
	/*
	 *  NO      NOT NULL NUMBER       
		FNO              NUMBER       
		ID               VARCHAR2(20) 
		NAME    NOT NULL VARCHAR2(51) 
		MSG     NOT NULL CLOB         
		REGDATE          DATE    
	 */
	
	private int no,fno;
	private String id,name,msg,dbday;
	private Date regdate;
}
