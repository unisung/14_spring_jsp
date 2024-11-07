package com.study.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository 
                 extends JpaRepository<Member, Long> {
	//findBy 뒤에 컬러명 붙여서 검색
	// select * from where name = keyword;
	Optional<Member> findByName(String keyword);
	//select * from  where email = keyword;
	Optional<Member> findByEmail(String keyword);
	
	//확장
	//select * from member where name like keyword
	List<Member> findByNameLike(String keyword);
	// select * from member where name like keyword order by name desc
	List<Member> findByNameLikeOrderByNameDesc(String keyword);
	// ~ order by name asc, email desc;
	List<Member> findByNameLikeOrderByNameAscEmailDesc(String keyword);
	
	// ~ where name like keyword order by sort조건
	List<Member> findByNameLike(String keyword, Sort sort);

}
