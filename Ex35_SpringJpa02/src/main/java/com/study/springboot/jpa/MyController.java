package com.study.springboot.jpa;

import java.util.List;
import java.util.Optional;

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
	
	@RequestMapping("/selectById")
	public String selectById(@RequestParam("id") Long search,
			             Model model) {
		Optional<Member> result 
		           = memberService.selectId(search);
		model.addAttribute("member", result.get());
		
		return "select_id"; //결과 페이지인 select_id.jsp로 forward
	}
	
	@RequestMapping("/selectByName")
	public String selectByName(@RequestParam("name") String search,
			             Model model) {
		Optional<Member> result 
		           = memberService.selectName(search);
		model.addAttribute("member", result.get());
		
		return "select_name"; //결과 페이지인 select_name.jsp로 forward
	}
	
	@RequestMapping("/selectByEmail")
	public String selectByEmail(@RequestParam("email") String search,
			             Model model) {
		Optional<Member> result 
		           = memberService.selectEmail(search);
		model.addAttribute("member", result.get());
		
		return "select_email"; //결과 페이지인 select_name.jsp로 forward
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		return "delete"; //삭제후 delete.jsp로 forward
	}
}
