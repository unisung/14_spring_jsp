package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//web서버에서 요청받아서 처리해주는 역할
public class MyController {
	@Autowired//스프링컨테이너가 주입 getBean() 대체
	Member member1;
	
	@Autowired
	@Qualifier("printerA")
	Printer printer ;
	
	@Autowired
	Member member2;
	//localhost:8080/
	@RequestMapping("/")
	public @ResponseBody String root() {
	member1.print();
	
	member1.setPrinter(printer);
	member1.print();
	
	return "Annotation 사용하기";
	
	}
}
