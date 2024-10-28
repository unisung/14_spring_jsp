package com.study.springboot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.dao.ISimpleBbsDao;
import com.study.springboot.dto.SimpleBbsDto;

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
		List<SimpleBbsDto> list=new ArrayList<>();
		list = dao.listDao();//요청을 dao에게 넘김
		model.addAttribute("list", list);//모델에 저장
		return "list"; //forward
	}
	//bbs상세보기  
	@RequestMapping("/view")
	public void view(SimpleBbsDto dto,//@ModelAttribute("dto")로 선언하는 경우,
			                        //view로 객체가 전달은 되지만 메소드내부에서 
			                        //값이 setting되는 과정이 없이 전달됨(주의!)
			         Model model//
			         ){
		//String sId = request.getParameter("id");//"2"
		//SimpleBbsDto 
		dto = dao.viewDao(Integer.toString(dto.getId()));
		model.addAttribute("dto", dto);//전달객체 저장
		//return "view";
	}
	
	@RequestMapping("/update/{id}")
	public String updateForm(@PathVariable("id") String id,
			                 Model model) {
		SimpleBbsDto dto = dao.viewDao(id);
		model.addAttribute("dto", dto);
		return "updateForm";
	}
	
	@RequestMapping(value="/update",
			        method=RequestMethod.POST)
	public String update(SimpleBbsDto dto) {
		 int result = dao.update(dto);
		return "redirect:/list"; //리다이렉트
	}
	
	//작성하기 - Form으로 가기
	@RequestMapping("/writeForm")
	public void view(){}
	
	//작성하기 - Form에서 controller로
	@RequestMapping(value="/write", 
			        method=RequestMethod.POST)
	public String write(HttpServletRequest request,
	         Model model){
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
//		Map<String,String> map = new HashMap<>();
//		map.put("writer", writer);
//		map.put("title", title);
//		map.put("content", content);
//		
//		int result = dao.writeDao2(map);
		
		SimpleBbsDto dto 
		  = new SimpleBbsDto(0, writer, title, content);
		
		int result = dao.writeDao3(dto); 
		
		System.out.println("입력된 행 수: "+ result);
		//dao.writeDao(writer, title, content);
		
			return "redirect:/list";
	}
	
	//삭제하기
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") String id){
		/* String id = request.getParameter("id"); */
		int result=dao.deleteDao(id);
		return "redirect:/list";
	}
	
	
	
	

}
