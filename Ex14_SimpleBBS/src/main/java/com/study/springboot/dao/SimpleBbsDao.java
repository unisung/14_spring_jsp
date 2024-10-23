package com.study.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springboot.dto.SimpleBbsDto;

@Repository
public class SimpleBbsDao implements ISimpleBbsDao{
	@Autowired
	private JdbcTemplate template;

	@Override
	public List<SimpleBbsDto> listDao() {
		System.out.println("listDao()");
		
		String query = "select * from simple_bbs order by id desc";
		List<SimpleBbsDto> dtos 
		   = template.query(query, 
	new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));
		
		return dtos;
	}

	@Override
	public SimpleBbsDto viewDao(String id) {
		System.out.println("viewDao()");
		return null;
	}

	@Override
	public int writeDao(String writer, String title, String content) {
		System.out.println("writeDao()");
		String query = "insert into simple_bbs(id, writer, title, content) "
		             + " values(simple_bbs_seq.nextval,?,?,?)";
		//update()메소드 실행결과 값은 insert된 행의 수(1)
		int result
		     =template.update(query,writer, title, content );
		return result;
	}

	@Override
	public int deleteDao(String id) {
		System.out.println("deleteDao()");
		return 0;
	}

}
