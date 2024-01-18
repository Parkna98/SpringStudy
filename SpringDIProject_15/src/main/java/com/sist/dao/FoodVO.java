package com.sist.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// @NoArgsConstructor
// @AllArgsConstructor
// 생성자 만드는 Annotation
// 매개변수 없는거, 있는거
public class FoodVO {
	private int fno;
	private String name,address,type;
}
