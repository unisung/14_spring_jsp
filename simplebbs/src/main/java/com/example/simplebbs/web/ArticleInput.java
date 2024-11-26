package com.example.simplebbs.web;

import jakarta.validation.constraints.NotBlank;

public class ArticleInput {
    @NotBlank(message = "제목은 필수 입력 항목입니다.") // 제목은 반드시 입력해야 함
    String subject;

    @NotBlank(message = "내용은 필수 입력 항목입니다.") // 내용은 반드시 입력해야 함
    String contents;

//    @NotBlank(message = "작성자는 필수 입력 항목입니다.") // 작성자는 반드시 입력해야 함
    String author;

    // Getter와 Setter
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
}
