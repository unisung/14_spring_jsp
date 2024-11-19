package com.study.springboot.controller;

import java.nio.charset.StandardCharsets;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProxyController {
	
	@GetMapping("/rss")
	public ResponseEntity<String> getRssFeed(){
    //rssUrl경로
	String rssUrl 
	  ="http://myhome.chosun.com/rss/www_section_rss.xml";
	//restTemplate객체 생성
	RestTemplate restTemplate = new RestTemplate();
	
	//utf-8 한글 인코딩 설정
	restTemplate.getMessageConverters()
   .add(0, 
	new StringHttpMessageConverter(StandardCharsets.UTF_8));
	//데이타 문자열
	String rssData 
	  = restTemplate.getForObject(rssUrl, String.class);
	//200 ok 메세지를 추가해서 응답 문자열 리턴.
	return ResponseEntity.ok(rssData);
	//rssData전달.head에 200 ok추가
	}

}
