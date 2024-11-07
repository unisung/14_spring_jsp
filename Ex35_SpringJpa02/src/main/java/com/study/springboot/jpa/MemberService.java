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
	public Member insert(Member member) {
		Member returnMember = memberRepository.save(member);
		return returnMember;
	}
	//한 건 조회
	public Optional<Member> select(Long id){
		Optional<Member> member 
		           = memberRepository.findById(id);
		return member;
	}
	//여러건 조회
	public List<Member> selectAll(){
		return memberRepository.findAll();
	}
	
	//삭제
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	
	//수정
	public Member update(Member member) {
		System.out.println("update:"+member);
		//키 값과 같은 객체가 있으면 업데이트, 키 값과 같은 객체가 없으면 인서트
		Member returnMember = memberRepository.save(member);
		return returnMember;
	}
	

}
