package net.datasa.test.security;

import java.util.function.Supplier;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.test.domain.entity.MemberEntity;
import net.datasa.test.repository.MemberRepository;

/**
 * 사용자 인증 처리
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticatedUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String id) 
    		        throws UsernameNotFoundException {
        log.info("로그인 시도 : {}", id);
         
        MemberEntity memberEntity 
             = memberRepository.findById(id)
             .orElseThrow(() -> 
                new UsernameNotFoundException(id + " : 없는 ID입니다."));
        
        //인증 정보
        AuthenticatedUser user = AuthenticatedUser.builder()
        		.id(memberEntity.getMemberId())
        		.password(memberEntity.getMemberPw())
        		.memberName(memberEntity.getMemberName())
        		.build();

        return user;
    }
}
