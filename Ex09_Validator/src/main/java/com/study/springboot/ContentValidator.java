package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//spring에서 제공해주는 검증(입력값의 null여부, 타입)객체
public class ContentValidator implements  Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return ContentDto.class.isAssignableFrom(clazz) ;
	}//검증할 객체 클래스 타입정보

	@Override
	public void validate(Object target, Errors errors) {
		ContentDto dto = (ContentDto)target;
		
		String sWriter = dto.getWriter();
		// trim("  aaa ") -> "aaa", trim("    ") -> ""  
		if(sWriter  == null || sWriter.trim().isEmpty()) {
			System.out.println("Writer is null or empty");
			errors.rejectValue("writer", "trouble");//전달할 오류정보
		}
		
		String sContent = dto.getContent();
		if(sContent == null || sContent.trim().isEmpty()) {
			System.out.println("Content is null or empty");
			errors.rejectValue("content", "trouble");
		}
	}
}
