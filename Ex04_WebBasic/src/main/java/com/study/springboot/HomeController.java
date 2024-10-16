package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/sub/test")
	public String myTest() {
		return "sub/test";
	}
	
	@RequestMapping("/sub/test2")
	public String myTest2() {
		return "sub/test2";
	}
}
