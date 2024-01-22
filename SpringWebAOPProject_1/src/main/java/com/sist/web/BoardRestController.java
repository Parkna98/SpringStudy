package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
// RestController 
@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("board/update_ok.do")
	public String board_update_ok(BoardVO vo) {
		
		String result="";
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true) {
			result="<script>location.href=\"detail.do?no="+vo.getNo()+"\"</script>";
		}else {
			result="<script>"
					+"alert(\"비밀번호가 틀립니다\");"
					+"history.back();"
					+"</script>";
		}
		return result;
		
	}
}
