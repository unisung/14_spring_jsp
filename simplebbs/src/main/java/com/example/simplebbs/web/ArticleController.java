package com.example.simplebbs.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.simplebbs.article.Article;

@Controller
public class ArticleController {
	@GetMapping("/")
	public @ResponseBody String root() {
		return "hello world";
	}
	
	@GetMapping("/write")
	public String writePate(Model model) {
		model.addAttribute("articleInput", new ArticleInput());
		return "write";// resource/templates/write.html
	}

	@PostMapping("/write")
	public String submitForm(@Validated @ModelAttribute("articleInput") ArticleInput articleInput,
			BindingResult bindingResult ) {
		System.out.println("articleInput:"+articleInput);
		if(bindingResult.hasErrors()) {
			return "write";//입력폼으로 되돌아감.
		}
		//서비스 호출
		return "redirect:/";
	}
}
