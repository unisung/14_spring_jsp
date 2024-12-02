package com.example.simplebbs.article;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
	void insertArticle(Article article);
	List<Article> findAll();
	Optional<Article> findById(Long id);
	Article getArticleById(Long id);
	void updateArticle(Long id, String subject, String content);
	

}
