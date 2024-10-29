package com.study.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.ISimpleBbsDao;
import com.study.springboot.dto.SimpleBbsDto;

@Service
public class SimpleBbsService 
               implements ISimpleBbsService {
	@Autowired
	private ISimpleBbsDao dao;
	
	@Override
	public List<SimpleBbsDto> list() {
		return dao.listDao();//요청을 dao에게 넘김;
	}

	@Override
	public SimpleBbsDto view(String id) {
		return dao.viewDao(id);
	}

	@Override
	public int write(Map<String, String> map) {
		return dao.writeDao2(map);
	}

	@Override
	public int delete(String id) {
		return dao.deleteDao(id);
	}

	@Override
	public int count() {
		return dao.articleCount();
	}

	@Override
	public int update(SimpleBbsDto dto) {
		return dao.update(dto);
	}

}
