package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.dto.UserDTO;

@Mapper
public interface IDao {
	List<UserDTO> getEmployee();
}
