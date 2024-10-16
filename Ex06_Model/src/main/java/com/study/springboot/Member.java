package com.study.springboot;

public class Member {
	private Integer no;
	private String name;
	private String addr;
	private Integer age;
	
	public Member() {}
	
	public Member(Integer no, String name, String addr, Integer age) {
		this.no = no;
		this.name = name;
		this.addr = addr;
		this.age = age;
	}


	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", addr=" + addr + ", age=" + age + "]";
	}

}
