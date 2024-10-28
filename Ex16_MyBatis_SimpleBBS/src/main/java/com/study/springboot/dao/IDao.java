package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.dto.UserDTO;

@Mapper
public interface IDao {
	List<UserDTO> getEmployee();
	//사원번호로 사원정보 추출 메소드
	UserDTO getEmpInfo(String empno);
}
