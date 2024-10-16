package com.example.demo.bean;

public class Member {
	private String name;
	private String nickname;
	private Printer printer;
	public Member() {}
	//default생성자 소스코드에 없으며 컴파일시 추가
	//default super()도 컴파일시 추가
	public Member(String name, String nickname, Printer printer) {
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}
	//get+필드명 => 카멜방식 ,set+필드명
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Printer getPrinter() {
		return printer;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", nickname=" + nickname + ", printer=" + printer + "]";
	}
	
	public void print() {
		printer.print("Hello "+name+" : " + nickname);
	}
	
	
	
	
	

}
