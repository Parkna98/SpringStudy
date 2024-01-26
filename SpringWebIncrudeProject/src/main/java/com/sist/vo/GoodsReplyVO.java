package com.sist.vo;
/*
 * 	NO      NOT NULL NUMBER       
	GNO     NOT NULL NUMBER       
	TYPE    NOT NULL NUMBER       
	ID               VARCHAR2(50) 
	NAME             VARCHAR2(50) 
	MSG              CLOB         
	REGDATE          DATE   
 */

import java.util.Date;

import lombok.Data;
@Data
public class GoodsReplyVO {
	private int no,gno,type;
	private String id,name,msg,dbday;
	private Date regdate;
}
