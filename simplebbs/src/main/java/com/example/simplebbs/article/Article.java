package com.example.simplebbs.article;

import java.time.Instant;

public class Article {
	private Long id;
	private String subject;
	private String contents;
	private String author;
	private Long userId;
	private int commentCount; //댓글 수 필드
	
	private Instant createdAt;//생성일시
	private Instant updatedAt;//수정일시
	
	public Article(String subject, String contents, 
			       String author, Long userId, 
			       int commentCount) {
		this.subject = subject;
		this.contents = contents;
		this.author = author;
		this.userId = userId;
		this.commentCount = commentCount;
		this.createdAt = Instant.now();
		this.updatedAt = Instant.now();
	}

	public Article() {}
	
	//getters/setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", subject=" + subject + ", contents=" + contents + ", author=" + author
				+ ", userId=" + userId + ", commentCount=" + commentCount + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	
	
	
	
	
	
	
	
	

}
