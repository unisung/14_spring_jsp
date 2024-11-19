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
	/*	
JSON vs JSONP 비교
     특징:		JSON	          	JSONP
주요 목적	: 데이터 교환		      교차 도메인 요청 (CORS 우회)
데이터 형식: 순수 데이터(JSON 객체) JSON 데이터를 함수 호출로 감싸 반환
CORS 제한: CORS 설정 필요		  제한 없음 (스크립트 태그 활용)
MIME 타입: application/json	  application/javascript
보안	:	  안전 (순수 데이터)	  XSS 공격에 취약
구현 복잡도: 간단			     서버에서 콜백 함수 감싸기 필요
 
	*/

}
