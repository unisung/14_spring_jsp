package com.study.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	member = Member.builder().name("김종서")
		      .email("test10@test.com").build();
	memberRepository.save(member);
	
	member = Member.builder().name("김유신")
		      .email("test11@test.com").build();
	memberRepository.save(member);
	
	}
	//전체 조회
	public List<Member> selectAll(){
		return memberRepository.findAll();
	}
	//id조회
	public Optional<Member> selectId(Long search){
		return memberRepository.findById(search);
	}
	//이름 조회
	public Optional<Member> selectName(String search){
	    return memberRepository.findByName(search);
	}
	//이메일 조회
	public Optional<Member> selectEmail(String search){
		return memberRepository.findByEmail(search);
	}
	//이름 like
	public List<Member> selectNameLike(String search){
		return memberRepository.findByNameLike(search);
	}
	//이름 like order by
	public List<Member> selectNameLikeNameDesc(String search){
		return memberRepository.findByNameLikeOrderByNameDesc(search);
	}
	//이름 like sort
	public List<Member> selectNameLike(String search, Sort sort){
		return memberRepository.findByNameLike(search,sort);
	}
}
