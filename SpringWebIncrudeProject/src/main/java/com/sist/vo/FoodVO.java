package com.sist.vo;

import lombok.Data;

@Data
public class FoodVO {
	private int fno,hit;
	private double score;
	private String poster,name,type,address,phone,theme,price,time,seat,content;
}
