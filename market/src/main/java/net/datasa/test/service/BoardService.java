package net.datasa.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.datasa.test.domain.dto.BoardDTO;
import net.datasa.test.domain.entity.BoardEntity;
import net.datasa.test.repository.BoardRepository;
import net.datasa.test.repository.MemberRepository;
import net.datasa.test.repository.ReplyRepository;

/**
 * 게시판 서비스
 */
@RequiredArgsConstructor
@Service
@Transactional
public class BoardService {
  //게시판 관련 Repository
    private final BoardRepository boardRepository;
  //리플 관련 Repository
    private final ReplyRepository replyRepository;
  //회원 관련 Repository
    private final MemberRepository memberRepository;

    public List<BoardDTO> getList(String category,
    		         String keyword) {
    	List<BoardEntity> entityList 
    	 = boardRepository.selectBoardList(category, keyword);	
    	
    	List<BoardDTO> dtoList = new ArrayList<>();
    	
    	for(BoardEntity entity : entityList) {
    		BoardDTO dto = BoardDTO.builder()
    				.boardNum(entity.getBoardnum())
    				
    	}
    	
    }
    
}
