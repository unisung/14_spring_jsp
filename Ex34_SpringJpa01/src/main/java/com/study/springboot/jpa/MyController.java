package com.study.springboot.jpa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() throws Exception{
		return "menu"; //menu.jsp로 forward
	}
	
	@RequestMapping("/insert")
	public String insert(@RequestParam("username") 
	                                String username,
			              Model model) {
	  Member member 
	   = Member.builder() // Member()
		  .username(username) //member.setUserName(username)
		  .createDate(LocalDate.now()) //member.setCreateDate(now())
		  .build();
	  
	  Member result = memberService.insert(member);
	  model.addAttribute("member",result);
	  
	  return "insert";// insert.jsp페이지로 forwarding
	}
	
	
	

}
