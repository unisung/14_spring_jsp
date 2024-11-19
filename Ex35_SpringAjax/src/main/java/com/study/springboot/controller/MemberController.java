package com.study.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.dto.Member;

@RestController
public class MemberController {
	
	@GetMapping("/members")
	public String 
	getMembers(@RequestParam("callback") String callback){
		//Member객체 리스트
	List<Member> members = new ArrayList<>();
	members
	.add(new Member("1","Choldcroft","dcroft0@hibu.com"));
	members
	.add(new Member("2","Levi","wlevi1@blogger.com"));
	members
	.add(new Member("3","nl","laxcellc@ebay.co.uk"));
	
	//JSON 데이터를 JSONP형식으로 감싸기
	String jsonData="["
	+ "{\"id\":\"1\",\"name\":\"Choldcroft\",\"email\":\"dcroft0@hibu.com\"},"
	+ "{\"id\":\"2\",\"name\":\"Levi\",\"email\":\"wlevi1@blogger.com\"},"
	+ "{\"id\":\"3\",\"name\":\"nl\",\"email\":\"laxcellc@ebay.co.uk\"},"
	+ "]";	
	
	System.out.println(jsonData);
	
	return callback +"("+jsonData+")";//callback(jsonData);
	//myFnc(jsonData);
	}

}
