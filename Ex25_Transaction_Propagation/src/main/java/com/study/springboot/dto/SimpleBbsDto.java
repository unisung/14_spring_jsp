package com.study.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleBbsDto {
	private int id;
	private String writer;
	private String title;
	private String content;
}
