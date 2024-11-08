package com.study.springboot.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository 
                 extends JpaRepository<Member, Long> {
//	Page<Member> findByNameLike(String keyword, 
//			         Pageable pageable);
	
	//일반 JPQL쿼리, from뒤는 엔티티명 (소문자로 하면 에러발생)
	@Query("select m from JPAMEMBER03 m where m.name like :name1 order by m.id desc")
	List<Member> findMembers(@Param("name1") String name2);
	//조회결과 Sort객체 정보로 정렬
	@Query("select m from JPAMEMBER03 m where m.name like :name1")
	List<Member> findMembers(@Param("name1") String name2,
			                  Sort sort);
	//조회결과 Pageable객체 정보로 페이징 처리
	@Query("select m from JPAMEMBER03 m where m.name like :name1")
	Page<Member> findMembers(@Param("name1") String name2,
                             Pageable pageable);
	//Native 쿼리문 사용
	//일반 SQL: 테이블명 대소문자 구분안함.
	@Query(value="select * from jpamember03 where name like "
			   + " :name1 order by id desc", 
			nativeQuery=true)
	List<Member> findMembersNative(@Param("name1") 
	                                      String name2);
	
}
