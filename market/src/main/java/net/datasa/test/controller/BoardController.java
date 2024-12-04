package net.datasa.test.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.test.domain.dto.BoardDTO;
import net.datasa.test.domain.dto.MemberDTO;
import net.datasa.test.security.AuthenticatedUser;
import net.datasa.test.service.BoardService;
import net.datasa.test.service.MemberService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 거래 게시판 관련 콘트롤러
 */

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("board")
public class BoardController {
	//게시판 처리 서비스
    private final BoardService boardService;
    /**
    * 글목록으로 이동
    * @return 글목록 HTML 파일
    */
    @GetMapping("list")
    public String list() {
    	return "board/list";
    }

   
}
