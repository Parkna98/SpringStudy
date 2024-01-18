package com.sist.mapper;
/*
 * 		name => N
 * 		address => A
 * 		type => T
 * 		name+address => NA
 * 		name+type => NT
 * 		address+type => AT
 *		name+address+type => NAT
 */
import java.util.*;
// (name LIKE '%'||#{ss}||'%') OR (address LIKE '%'||#{ss}||'%')
// prefixOverrides="OR" => 맨앞에 있는 OR는 지워라
// prefix="("  suffix=")"  ==> 앞에 ( 붙이고 끝날때 ) 붙이기
/*
		if(ss=='N')
		OR name LIKE ~
		else if(ss=='A')
		OR address LIKE ~
		else if(ss=='T')
		OR type LIKE ~
 */

import org.apache.ibatis.annotations.Select;

import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;
public interface FoodMapper {
	@Select("<script>"
			 +"SELECT fno,name,type,address "
			 +"FROM food_menu_house "
			 +"WHERE "
			 +"<trim prefix=\"(\" suffix=\")\" prefixOverrides=\"OR\">"
			 +"<foreach collection=\"fsArr\" item=\"fd\">"
			 +"<choose>"
			 +"<when test=\"fd=='N'.toString()\">"
			 +"OR name LIKE '%'||#{ss}||'%'"
			 +"</when>"
			 +"<when test=\"fd=='A'.toString()\">"
			 +"OR address LIKE '%'||#{ss}||'%'"
			 +"</when>"
			 +"<when test=\"fd=='T'.toString()\">"
			 +"OR type LIKE '%'||#{ss}||'%'"
			 +"</when>"
			 +"</choose>"
			 +"</foreach>"
			 +"</trim>"
			 +"</script>"
			)
			public List<FoodVO> foodFindData(Map map);
	
	/*
	 		trim => 추가 (prefix,suffix)
	 			 => 삭제 (prefixOverrides, suffixOverrides)
	 			 
	 		fd=='N' => "N" = 65
	 		==> fd=='N'.toString()
	 */
		
	
	
	
	
}
