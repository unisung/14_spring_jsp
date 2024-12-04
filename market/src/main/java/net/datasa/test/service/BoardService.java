package net.datasa.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.datasa.test.domain.dto.BoardDTO;
import net.datasa.test.domain.entity.BoardEntity;
import net.datasa.test.domain.entity.MemberEntity;
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
    				.boardNum(entity.getBoardNum())
    				.memberId(entity.getMember().getMemberId())
    				.category(entity.getCategory())
    				.title(entity.getTitle())
                    .contents(entity.getContents())
                    .price(entity.getPrice())
                    .soldout(entity.getSoldout())
                    .buyerId(entity.getBuyer() == null ?
                    		 "" : entity.getBuyer().getMemberId())
                    .inputDate(entity.getInputDate())
                    .build();
    		
    		 dtoList.add(dto);			
    	}
    	
    	return dtoList;
    }
    
    /**
     * 글 저장
     * @param boardDTO 게시글 정보
     */
    public void write(BoardDTO boardDTO) {
    	MemberEntity memberEntity 
    	= memberRepository.findById(boardDTO.getMemberId())
    	 .orElseThrow(()
    			-> new EntityNotFoundException("회원정보가 없습니다."));
    	//글 정보 저장
    	BoardEntity boardEntity = BoardEntity.builder()
    			.member(memberEntity)
    			.category(boardDTO.getCategory())
    			.title(boardDTO.getTitle())
    			.contents(boardDTO.getContents())
    			.price(boardDTO.getPrice())
    			.soldout(false)
    			.build();
    	
    	boardRepository.save(boardEntity);
    }
}
