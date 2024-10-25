package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dao.IDao;
import com.study.springboot.dto.UserDTO;

@Controller
public class UserController {
	@Autowired
	private IDao dao;
	
  @RequestMapping("/employees")
  public String userlistPage(Model model) {
	  List<UserDTO> list = dao.getEmployee();
	  for(UserDTO dto: list) {
		  System.out.println(dto);
	  }
	  model.addAttribute("employees", list);
	  
	  return "employeelist";
  }
}
