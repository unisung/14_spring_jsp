package com.study.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.jdbc.MyUserDAO;
import com.study.springboot.jdbc.MyUserDTO;

@Controller
public class MyController{
	@Autowired
	private MyUserDAO userDAO;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "JdbcTemplate 사용하기";
	}
	
	@RequestMapping("/user")
	public String userlistPage(Model model) {
		//전달할 객체 리스트
		List<MyUserDTO> list = new ArrayList<>();
		//DAO부터 전달받은 객체들을 list에 담기
		list = userDAO.listForBeanPropertyRowMapper();
		//view로 보내기 위해 model의속성으로 저장
		model.addAttribute("users", list);
		//이동할 view 지정
		return "userlist";
	}
	
}
