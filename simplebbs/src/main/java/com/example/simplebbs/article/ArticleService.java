package com.example.simplebbs.article;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ArticleService {
	private final ArticleMapper articleMapper;

	public ArticleService(ArticleMapper articleMapper) {
		this.articleMapper = articleMapper;
	}
	
	public List<Article> getAllArticles(){
		return articleMapper.findAll();
	}
	
	public void writeArticle(String subject, String content, String author) {
		Article article 
		= new Article(subject, content, author);
		articleMapper.insertArticle(article);
	}
	
}
