package com.example.simplebbs.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		//model.addAttribute("article", new Article());
		return "write";// resource/templates/write.html
	}

	@PostMapping("/write")
	public String submitForm(@ModelAttribute("article") Article article) {
		System.out.println("article:"+article);
		return "redirect:/";
	}
}
