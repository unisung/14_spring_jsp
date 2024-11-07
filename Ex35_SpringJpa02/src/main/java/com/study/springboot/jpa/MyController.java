package com.study.springboot.jpa;

import java.util.List;

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
	public String insert(Member member, 
			              Model model) {
	    memberService.insert();
		return "insert";// insert.jsp페이지로 forwarding
	}
	
	@RequestMapping("/selectAll")
	public String selectAll(Model model) {
		List<Member> result = memberService.selectAll();
		model.addAttribute("members", result);
		return "selectAll";//selectAll.jsp로 forward
	}
	
	@RequestMapping("/update")
	public String update(Member member,
			             Model model) {
		return "update"; //결과 페이지인 update.jsp로 forward
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		return "delete"; //삭제후 delete.jsp로 forward
	}
}
