package com.study.springboot.jpa;

import java.time.LocalDate;
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
	
	@RequestMapping("/select")
	public String select(@RequestParam("id") Long id, 
			Model model) {
		Optional<Member> result= memberService.select(id);
		//파라미터로 전달된 id에 해당하는 정보가 있으면
		if(result.isPresent()) {
			Member member = result.get();
			model.addAttribute("member", member);
		}else {// 없으면
			model.addAttribute("member", null);
		}
		
		return "select"; //select.jsp로 forward
	}
	
	@RequestMapping("/selectAll")
	public String selectAll(Model model) {
		List<Member> result 
		              = memberService.selectAll();
		model.addAttribute("members", result);
		
		return "selectAll";//selectAll.jsp로 forward
	}
	
	@RequestMapping("/update")
	public String update(Member member, Model model) {

		
		//수정 날짜 세팅
		member.setCreateDate(LocalDate.now());
		//수정내용을 DB에 저장후, DB에 저장된 객체를 얻기
		Member result = memberService.update(member);
		
		System.out.println(member);
		model.addAttribute("member",result);
		
		return "update"; //결과 페이지인 update.jsp로 forward
	}
	

}
