package net.datasa.test.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.test.domain.dto.BoardDTO;
import net.datasa.test.service.BoardService;

/**
 * 거래 게시판 Ajax 요청 처리 콘트롤러
 */

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("board")
public class BoardRestController {
	//게시판 처리 서비스
	private final BoardService boardService;
	 /**
     * 글 목록 조회
     * @param category      판매상품 카테고리
     * @param keyword       검색어
     * @return              게시글 목록
     */
	//ResponseEntity - 응답결과물과  상태값을 같이 전달(ajax)
	@PostMapping("getList")
	public ResponseEntity<?> getList
	(@RequestParam("category") String category,
	 @RequestParam("keyword") String keyword
	) {
		List<BoardDTO> list 
		  = boardService.getList(category, keyword);
		
		return ResponseEntity.ok(list);//status-200, 결과값-list		
	}

	
  
}
