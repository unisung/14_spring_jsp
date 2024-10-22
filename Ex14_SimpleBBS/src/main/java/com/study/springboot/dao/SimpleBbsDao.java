package com.study.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		return null;
	}

	@Override
	public SimpleBbsDto viewDao(String id) {
		System.out.println("viewDao()");
		return null;
	}

	@Override
	public int writeDao(String writer, String title, String content) {
		System.out.println("writeDao()");
		return 0;
	}

	@Override
	public int deleteDao(String id) {
		System.out.println("deleteDao()");
		return 0;
	}

}
