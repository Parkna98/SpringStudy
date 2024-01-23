package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// board/list, board/detail 등 겹치는 경로는 클래스에 RequestMapping("board/")라고 붙이면 아래 메소드가 이어받는다

@Controller
@RequestMapping("databoard/") // 공통 경로 저장
// GetMapping / PostMapping
//				=========== ajax,axios,form
public class DataBoardController {

}
