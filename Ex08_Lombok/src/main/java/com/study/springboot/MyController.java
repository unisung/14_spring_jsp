package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "Lombok";
	}
	
	@RequestMapping("/test1")
	public String test1(Member member, Model model) {
		System.out.println(member);
		return "test1";
	}
	
	
	

}
