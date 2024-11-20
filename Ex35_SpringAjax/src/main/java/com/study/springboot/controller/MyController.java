package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@GetMapping("/")
	public @ResponseBody String root() {
		return "hello";
	}
	
	@GetMapping("/jqa4") // jqa4.jsp
	public void jqa4() {}
	
	@GetMapping("/jqa5") // jqa5.jsp
	public void jqa5() {}
	
	@GetMapping("/jqa6") // jqa6.jsp
	public void jqa6() {}
	
	@GetMapping("/jqa7") // jqa7.jsp
	public void jqa7() {}
	
	@GetMapping("/memberLogon") //
	public String memberLogon() {
		return "member_logon";//member_logon.jsp
	}
	
	

}
