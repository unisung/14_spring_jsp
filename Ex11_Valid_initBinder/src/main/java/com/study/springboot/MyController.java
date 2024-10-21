package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "Validator (1)";
	}
	
	@RequestMapping("/insertForm")
	public String insert1() {
		return "createPage";// /WEB-INF/views/createPage.jsp
	}
	
	
	@RequestMapping("/create")
	public String insert2(@ModelAttribute("dto") 
	                      @Validated
	                       ContentDto contentDto,
			BindingResult result) {
		//정상처리시이동할 페이지 
		String page = "createDonePage";//처리후 이동할 페이지
		System.out.println(contentDto);//콘솔에 출력
		
//		ContentValidator validator 
//		            = new ContentValidator();
		//검증
//		validator.validate(contentDto, result);
		//오류가발생하면 처리
		if(result.hasErrors()) {
			System.out.println("getAllErrors:"
		                       +result.getAllErrors());
			//writer에 오류발생하면
			if(result.getFieldError("writer") !=null) {
				System.out.println("1:"
			           +result.getFieldError("writer").getCode());
			}
			if(result.getFieldError("content") !=null) {
				System.out.println("2:"
			           +result.getFieldError("content").getCode());
			}
			page = "createPage";//이전페이지로 되돌아가기 처리
		}

		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		//setter injection
		binder.setValidator(new ContentValidator());
		//constructor injection
		//binder=new WebDataBinder(new ContentValidator());
	}
}
