package com.study.springboot.jpa;

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
	  return "insert";// insert.jsp페이지로 forwarding
	}
	
	@RequestMapping("/select")
	public String select(@RequestParam("id") Long id, 
			Model model) {
		return "select"; //select.jsp로 forward
	}
	
	@RequestMapping("/selectAll")
	public String selectAll(Model model) {
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
