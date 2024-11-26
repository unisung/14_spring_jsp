package com.example.simplebbs.web;

import jakarta.validation.constraints.NotBlank;

//입력데이타 검증 여부체크객체
public class ArticleInput {
	@NotBlank(message = "제목을 입력해 주세요")
	String subject;
	@NotBlank(message = "내용을 입력해 주세요")
	String content;
	@NotBlank(message = "이름을 입력해 주세요")
	String author;
	
	//getter/setters
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	

}
