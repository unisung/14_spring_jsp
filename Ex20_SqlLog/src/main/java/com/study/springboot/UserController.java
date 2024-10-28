package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	  model.addAttribute("employees", list);
	  return "employeelist";
  }
  
  //localhost:8787/employee/7782
  @GetMapping("/employee/{empno}") 
  public String empInfo(@PathVariable("empno") String empno,
		  Model model) {
	  //dao로 empno에 해당하는 정보를 요청
	  UserDTO emp= dao.getEmpInfo(empno);
	  model.addAttribute("empInfo", emp);
	  return "employee";//employee.jsp
  }
  
}
