package com.example.simplebbs.web;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.simplebbs.article.Article;
import com.example.simplebbs.article.ArticleService;

@Controller
public class ArticleController {
	private final ArticleService articleService;
	
    public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@GetMapping("/write")
    public String writePage(Model model) {
        model.addAttribute("articleInput", new ArticleInput());
        return "article/write";
    }

    @PostMapping("/write")
    public String submitForm(@Validated @ModelAttribute ArticleInput articleInput,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "article/write";
        }

        // ArticleService의 writeArticle 메소드 호출
        articleService.writeArticle(articleInput.getSubject(), articleInput.getContent(), articleInput.getAuthor());
         
        return "redirect:/";
    }

    @GetMapping("/")
    public String list(Model model) {
       List<Article> articles 
          = articleService.getAllArticles();
       model.addAttribute("articles", articles);
        return "article/list";//list.html
    }

    @GetMapping("/article/{id}")
    public String article(@PathVariable(value = "id") Long id, 
    		Model model) {
    	Article article = articleService.getById(id);
    	model.addAttribute("article", article);
    	return "article/view"; //view.html
    }
    
    //수정폼으로 이동
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
    	System.out.println("x");
    	Article article = articleService.getById(id);
    	System.out.println("y");
    	model.addAttribute("article", article);
    	System.out.println("z");
    	return "article/edit";
    }
    
    //수정폼에서 전달된 파라미터를 이용해 db에 수정처리
    @PostMapping("/edit/{id}")
    public String editArticle(@PathVariable("id") Long id,
    		@ModelAttribute ArticleInput articleInput,
    		BindingResult bindingResult) throws AccessDeniedException {
    	
    	try {
    		if (bindingResult.hasErrors()) {
    			return "article/edit";
    		}
    		articleService.updateArticle(id, articleInput.getSubject(),articleInput.getContent(), articleInput.getAuthor());
    		return "redirect:/article/"+id;
    		
    	   }catch(IllegalStateException ise) {
    		   throw new AccessDeniedException("글을 수정할 권한이 없습니다.");
    	   }
    }
   
}
