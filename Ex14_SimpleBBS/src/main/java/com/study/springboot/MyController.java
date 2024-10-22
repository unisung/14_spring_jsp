package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.springboot.dao.ISimpleBbsDao;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class MyController {
	@Autowired
	private ISimpleBbsDao dao;
	
	@RequestMapping("/")
	public String root() throws Exception{
		return "redirect:/list";//다른페이지로 보내기 redirect
	}
	
	//bbs리스트
	@RequestMapping("/list")
	public String userlistPage(Model model){
		dao.listDao();
		return "list";
	}
	//bbs상세보기  
	@RequestMapping("/view")
	public String view(HttpServletRequest request,
			         Model model){
		dao.viewDao("1");
		return "view";
	}
	//작성하기 - Form으로 가기
	@RequestMapping("/writeForm")
	public String view(){
		return "writeForm";
	}
	//작성하기 - Form에서 controller로
	@RequestMapping(value="/write", 
			        method=RequestMethod.POST)
	public String write(HttpServletRequest request,
	         Model model){
			return "redirect:/list";
	}
	//삭제하기
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,
	         Model model){
		dao.deleteDao("1");
		return "redirect:/list";
	}
	
	
	
	

}
