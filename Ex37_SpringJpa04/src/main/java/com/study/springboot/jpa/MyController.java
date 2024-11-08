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

	@RequestMapping("/selectByNameLike")
	public String selectByNameLike(@RequestParam("name") String search,
			                      @RequestParam("page") String page,
			                      Model model){
		System.out.println("***" + search + "***");
		System.out.println("***" + page + "***");
		
		String name = "%" + search + "%";
	    Sort sort 
	   = Sort.by(Sort.Order.desc("name"));//정렬기준칼럼-"name"
	    int nPage = Integer.parseInt(page) -1;	//page시작 0
	    
	    // 페이지는 0부터
	    Pageable pageable = PageRequest.ofSize(10)//페이지당 글 개수
	    		                       .withPage(nPage)//현재페이지-1
	    		                       .withSort(sort);//정렬기준
	    
	    //위에서 생성한 페이지정보와 조회조건으로 조회결과를 Page에 담기
	    Page<Member> result 
	       = memberService.selectNameLike(name, pageable);
	    List<Member> content = result.getContent();
	    long totalElements = result.getTotalElements();
	    int totalPages = result.getTotalPages();
	    int size = result.getSize();
	    int pageNumber = result.getNumber() + 1;//!!!
	    int numberOfElements = result.getNumberOfElements();//콘텐츠 갯수
	    
	    //모델에 저장하여 forward되는 페이지로 전달
	    model.addAttribute("members", content);
	    model.addAttribute("totalEements", totalElements);
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("size", size);
	    model.addAttribute("pageNumber", pageNumber);
	    model.addAttribute("numberOfElements", numberOfElements);
	    
		return "select_name_list";//select_name_list.jsp로 forward.
		
	}
}
