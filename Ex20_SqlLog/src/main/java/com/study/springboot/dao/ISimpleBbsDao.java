package com.study.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.SimpleBbsDto;

@Mapper
public interface ISimpleBbsDao {
    //리스트 기능
	public List<SimpleBbsDto> listDao();
	//상세보기 기능
	public SimpleBbsDto viewDao(String id);
	//작성기능
	public int writeDao(@Param("writer") String writer,
						@Param("title") String title, 
						@Param("content") String content);
	//삭제기능
	public int deleteDao(String id);
	public int update(SimpleBbsDto dto);
	public int writeDao2(Map<String, String> map);
	public int writeDao3(SimpleBbsDto dto);
	
}
