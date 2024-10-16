package com.study.springboot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping("/") //Get요청이 default임
	public @ResponseBody String root() {
		return "Model & View";
	}
	
	@GetMapping("/test1") //spring 4.3이후 도입
	public String test1() {
		return "test1"; // /WEB-INF/views/test1.jsp
	}
	
	//value와 method방식 지정
	@RequestMapping(value = "/test2",method=RequestMethod.GET)
	public String test2() {
		return "myView"; //  /WEB-INF/views/test2.jsp
	}
	
// 스프링 - ModelAndView객체를 이용한 페이지이동과 객체 전달
	@GetMapping("/mv")
	public ModelAndView test3(Model model) {
		ModelAndView mv = new ModelAndView();
		
		List<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		
		Set<String> set = new HashSet<>();
		set.add("set-test1");
		set.add("set-test2");
		set.add("set-test3");
		
		mv.addObject("sets",set);//Set -> Object
		mv.addObject("lists", list);// List -> Object 
		mv.addObject("ObjectTest", "테스트입니다");//
		mv.addObject("name","홍길동"); //String -> Object
		
		mv.setViewName("view/MyView");
		
		return mv;
	}
	
// 스프링 - ModelAndView객체를 이용한 페이지이동과 객체 전달	
	@GetMapping("/mv2") // localhost:8787/mv2
	public ModelAndView test4(Model model) {
		ModelAndView mv = new ModelAndView();
		List<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		
		Set<String> set = new HashSet<>();
		set.add("set-test1");
		set.add("set-test2");
		set.add("set-test3");
		
		mv.addObject("sets",set);//Set -> Object
		mv.addObject("lists", list);// List -> Object 
		mv.addObject("ObjectTest", "테스트입니다");//
		mv.addObject("name","홍길동"); //String -> Object
		
		mv.setViewName("view/MyView2");// /WEB-INF/views/view/MyView2.jsp
		
		return mv;
	}
	
// 스프링 - String을 이용한 페이지이동과 Model을 이용한객체 전달	
	@GetMapping("/mv3") // localhost:8787/mv3
	public String test5(Model model) {
		List<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		
		Set<String> set = new HashSet<>();
		set.add("set-test1");
		set.add("set-test2");
		set.add("set-test3");
		
		model.addAttribute("sets",set);//Set -> Object
		model.addAttribute("lists", list);// List -> Object 
		model.addAttribute("ObjectTest", "테스트입니다");//
		model.addAttribute("name","홍길동"); //String -> Object
		
		return "view/MyView2";// /WEB-INF/views/view/MyView2.jsp
	}
	
	@GetMapping("/members")
	public String members(Model model) {
		Member m1 = new Member(1, "홍길동", "광주시", 25);
		Member m2 = new Member(2, "일지매", "서울시", 19);
		Member m3 = new Member(3, "임꺽정", "대구시", 20);
		
		List<Member> list = new ArrayList<>();
		list.add(m1);  list.add(m2);  list.add(m3);
		
		model.addAttribute("members", list);

		return "view/MyMembers";
	}
}
