package com.study.springboot.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.SimpleBbsDto;

public interface ISimpleBbsService {
	public List<SimpleBbsDto> list();//글리스트 조회
	public SimpleBbsDto view(String id);//글 상세
	public int write(Map<String, String> map);//글등록
	public int delete(@Param("_id") String id);//글 삭제
	public int count();//건수
	public int update(SimpleBbsDto dto);//글 수정
}
