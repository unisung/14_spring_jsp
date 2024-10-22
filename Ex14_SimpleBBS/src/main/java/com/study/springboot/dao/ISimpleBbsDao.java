package com.study.springboot.dao;

import java.util.List;
import com.study.springboot.dto.SimpleBbsDto;

public interface ISimpleBbsDao {
    //리스트 기능
	public List<SimpleBbsDto> listDao();
	//상세보기 기능
	public SimpleBbsDto viewDao(String id);
	//작성기능
	public int writeDao(String writer,
			            String title, 
			            String content);
	//삭제기능
	public int deleteDao(String id);
	
}
