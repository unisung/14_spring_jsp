package com.study.springboot.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyUserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<MyUserDTO> listForBeanPropertyRowMapper(){
		String query = "select * from myuser";
		//test1                홍길동1
		//test2                홍길동2
		//test3                홍길동3
		List<MyUserDTO> list 
		   = jdbcTemplate.query(query, 
				   new BeanPropertyRowMapper<MyUserDTO>(MyUserDTO.class));
		return list;
	}

}
