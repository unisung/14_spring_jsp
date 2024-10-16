package com.study.springboot.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration//설정 정보파일
public class Config { //POJO(Plain Old Java Object)
	
	//@Bean //IOC컨테이너(spring)가 관리(생성,사용,주입,제거)
	public Member member1() {
		Member member1 = new Member();
		member1.setName("홍길동");
		member1.setNickname("도사");
		member1.setPrinter(new PrinterA());
		return member1;
	}
	
	//@Bean(name="hello")
	public Member member2() {
		//constructor인젝션 
		return new Member("전우치", "도사", new PrinterA());
	}
	
	//@Bean
	public PrinterA printerA() {
		return new PrinterA();
	}
	
	//@Bean
//	public PrinterB printerB() {
//		return new PrinterB();
//	}
}
