package com.study.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	//저장
	public void insert() {
	Member member;
    member = Member.builder().name("이순신")
    		      .email("test1@test.com").build();
    memberRepository.save(member);
    member = Member.builder().name("강감찬")
		      .email("test2@test.com").build();
    memberRepository.save(member);
    member = Member.builder().name("을지문덕")
		      .email("test3@test.com").build();
	memberRepository.save(member);
	member = Member.builder().name("계백")
		      .email("test4@test.com").build();
	memberRepository.save(member);
	member = Member.builder().name("김유신")
		      .email("test5@test.com").build();
	memberRepository.save(member);
	member = Member.builder().name("연개소문")
		      .email("test6@test.com").build();
	memberRepository.save(member);
	member = Member.builder().name("양만춘")
		      .email("test7@test.com").build();
	memberRepository.save(member);
	member = Member.builder().name("김종서")
		      .email("test8@test.com").build();
	memberRepository.save(member);
	member = Member.builder().name("최영")
		      .email("test9@test.com").build();
	memberRepository.save(member);
	}
	
	//한 건 조회

}
