package com.study.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	//샘플 회원 데이터
	private static final Map<String, String> members 
	 = new HashMap<>() {{
		put("korean","12345"); 
	 }};

	 private static final Map<String, String> memberNames 
	 = new HashMap<>() {{
		put("korean","박부장"); 
	 }};
	 
	@PostMapping("/member_logon_ok")
	public ResponseEntity<Map<String, String>> login(
			@RequestParam("user_id") String user_id,
			@RequestParam("user_pw") String user_pw){
		   //아이디와 비밀번호 확인
		if(members.containsKey(user_id) 
				&& members.get(user_id).equals(user_pw)) {
			Map<String, String> response = new HashMap<>();
			response.put("user_id", user_id);//"user_id","korean"			
			response.put("user_name", memberNames.get(user_id));//"user_name":"박부장"

		  return ResponseEntity.ok(response);//로그인성공 
		  //response정보를 응답으로 전달하면서 상태값을 200 ok로 넘김
	     } 
		 return ResponseEntity.status(401).build();//로그인 실패
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
