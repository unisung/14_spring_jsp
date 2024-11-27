package com.example.simplebbs.article;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Article {
    private Long id;
    private String subject;
    private String content;
    private String author;
    private Long userId;
    private int commentCount; // 댓글 수 필드 추가

   
    private Instant createdAt;
    private Instant updatedAt;

    // 모든 필수 필드를 포함한 생성자
//    public Article(String subject, String content, String author, Long userId) {
//        this.subject = subject;
//        this.content = content;
//        this.author = author;
//        this.userId = userId;
//        this.createdAt = Instant.now();
//        this.updatedAt = Instant.now();
//    }
    
    

    public Article(String subject, String content, String author) {
		this.subject = subject;
		this.content = content;
		this.author = author;
	}



	public boolean isAuthor(Long userId) {
        return Objects.equals(this.userId, userId);
    }

  

    // Getter 메서드
    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Long getUserId() {
        return userId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Article{" +
                "subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", id=" + id +
                '}';
    }

    public int getCommentCount() {
        return commentCount;
    }


}
