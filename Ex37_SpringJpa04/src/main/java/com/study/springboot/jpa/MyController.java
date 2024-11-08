package com.study.springboot.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	@RequestMapping("/selectByNameLike1")
	public String selectByNameLike(@RequestParam("name") String search,  
			                       Model model){
		
		System.out.println("***1" + search + "***");
		
		String name = "%" + search + "%";
	   
	    List<Member> result 
	              = memberService.selectMembers1(name);
	   
	    //모델에 저장하여 forward되는 페이지로 전달
	    model.addAttribute("members", result);
	    
		return "select_name_list_1";//select_name_list_1.jsp로 forward.
		
	}
}
