package net.datasa.test.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.test.domain.dto.MemberDTO;
import net.datasa.test.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 회원 관련 콘트롤러
 */

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("member")
public class MemberController {
	//회원정보 처리 서비스
	private final MemberService memberService;
	
	/**
     * 로그인폼으로 이동
     * @return 로그인폼 HTML 파일
     */
    @GetMapping("loginForm")
    public String loginForm() {
        return "member/loginForm";
    }
    
    /**
     * 가입폼으로 이동
     * @return 가입폼 HTML 파일
     */
    @GetMapping("join") //member/join
    public String join() {
        return "member/joinForm";//templates/member/joinForm.html
    }
    
    /**
     * 가입 정보를 입력받아 회원으로 등록하고 메인 페이지로 리다이렉트한다.
     * @param member    사용자가 입력한 가입 정보
     * @return          메인 페이지 리다이렉트 URL
     */
    @PostMapping("join")
    public String join(MemberDTO member) {
    	memberService.join(member);
    	return "redirect:/";
    }
    
}
