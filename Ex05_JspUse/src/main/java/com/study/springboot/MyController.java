package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	//클라이언트로부터 요청을 받는 어노테이션
	@RequestMapping("/") 
	public @ResponseBody String root() { //문자열 자체를 출력
		return "Hello MyPage"; // /WEB-INF/views/Hello MyPage.jsp
	}
	
	@RequestMapping("/test1")
	public String test1() {
		return "test1"; // /WEB-INF/views/test1.jsp
	}
	
	@RequestMapping("/test2") //localhost:8787/test2
	public String test2() {
		return "sub/test2"; // /WEB-INF/views/sub/test2.jsp
	}
	
	@RequestMapping("/test3") // localhost:8787/test3
	public String test3() {
		return "sub/test3"; // /WEB-INF/views/sub/test3.jsp
	}

}
