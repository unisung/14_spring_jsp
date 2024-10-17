package com.study.springboot;

public class Member {
	private String id;
	private String name;
	private String password;
	private String address;
	
	public Member(String id, String name, String password, String address) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Member() {}

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "회원정보 [아이디=" + id + ", 이름=" + name + "]";
	}

}
