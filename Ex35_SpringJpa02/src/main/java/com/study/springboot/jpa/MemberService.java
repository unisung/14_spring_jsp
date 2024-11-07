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
    
	}
	
	//한 건 조회

}
