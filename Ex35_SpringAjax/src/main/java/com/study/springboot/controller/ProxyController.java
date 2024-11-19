package com.study.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProxyController {
	
	@GetMapping("/rss")
	public ResponseEntity<String> getRssFeed(){
	String rssUrl 
	  ="http://myhome.chosun.com/rss/www_section_rss.xml";
	
	RestTemplate restTemplate = new RestTemplate();
	
	String rssData 
	  = restTemplate.getForObject(rssUrl, String.class);
	
	return ResponseEntity.ok(rssData);
	//rssData전달.head에 200 ok추가
	}

}
