package com.study.springboot;

import java.net.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	@RequestMapping("/hello")
	public @ResponseBody String hello() {
		return "hello MyController";
	}
	
	@RequestMapping("/input")
	public ModelAndView inputForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("inputForm2");
		return mv;
	}
	
	@RequestMapping("/test2-1")
	public @ResponseBody Member inputProc2(HttpServletRequest request) {
		String id=request.getParameter("id");
		String name=request.getParameter("name");

		return new Member(id, name);
	}
	
//	@RequestParam - 클라이언트로부터 파라미터를 전달해주는 처리 어노테이션
	//springboot 3.2 이전 @RequestParam String id 
	//             -> 3.2이후 @RequestParam("id") String id
	@RequestMapping("/test2-2")
	public @ResponseBody Member inputProc3(
			    @RequestParam("id") String id,
				@RequestParam("name") String name
			) {
		return new Member(id, name);
	}
	
	//두개이상의 데이타를 묶어서 파라미터로 받는 경우
	//@ModelAttribute로 받는게 일반적이다.
	@RequestMapping("/test2-3")
	public @ResponseBody Member inputProc4(@ModelAttribute Member member) {
		return member;
	}
	//@ModelAttribute는 생략가능함.
	@RequestMapping("/test2")
	public @ResponseBody Member inputProc(	Member member, 
			  @RequestParam(value="pwd", required = false) String password) {
		         member.setPassword(password);
		return member;
	}
	
	//@Pathvariable
	@RequestMapping("/test3/{id}/{name}")
	public @ResponseBody Member getMember(
			  @PathVariable("id") String id,
			  @PathVariable("name") String name
			) {
		return new Member(id,name);
	}
	
	
	
	
	
}


/*
 * HttpServletRequest
@RequestParam  - 기본타입(byte,short,char, int,long, float, double, boolean)
               - 래퍼타입(Byte, Short, Character, Integer, Long, Float, Double, Boolean)
	       - List<String>, List<Integer> 등 간단한 리스트 타입
@RequestParam에서 주의사항 - 파라미터를 못받는경우 오류발생
                          -해결방법 : required=false로 지정
 
@ModelAttribute - 사용자정의 DTO(UserDto, Product, Order, Member)

@ModelAttribute사용조건 - 파라미터명과 필드명같아야하고, setter메소드가 있어야함.


@Pathvariable - 파라미터값을 주소경로형태로 전달

String message  = null;  message==null <- true,
String message2 = "";    message2.isEmpty() <- true
 * 
 * 
 * */
