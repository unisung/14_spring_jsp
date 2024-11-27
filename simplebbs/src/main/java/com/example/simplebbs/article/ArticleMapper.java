package com.example.simplebbs.article;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
	void insertArticle(Article article);
	List<Article> findAll();

}
