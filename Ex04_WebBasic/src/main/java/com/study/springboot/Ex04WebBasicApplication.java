package com.study.springboot;
//welcome페이지로 index.html파일이 등록이 되어있어서
//Controller없이 index.html파일 자동실행
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex04WebBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex04WebBasicApplication.class, args);
	}

}
