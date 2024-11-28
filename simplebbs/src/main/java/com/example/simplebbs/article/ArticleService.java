package com.example.simplebbs.article;

import java.util.List;
import java.util.Optional;

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

	public Article getById(Long id) {
		//리턴되는 객체가 null인경우 에러발생방지
		Optional<Article> article = articleMapper.findById(id);
		return article.orElseThrow();
	}
	
}
