package com.study.springboot.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	public List<Member> selectMembers1(String search){
		return memberRepository.findMembers(search);
	}
	
	public List<Member> selectMembers2(String search, 
			                          Sort sort){
		return memberRepository.findMembers(search,sort);
	}
	
	public List<Member> selectMembers3(String search, 
			                       Pageable pageable){
		return memberRepository.findMembers(search,pageable);
	}
	
	public List<Member> selectMembers4(String search){
		return memberRepository.findMembersNative(search);
	}
	
	
	
}
