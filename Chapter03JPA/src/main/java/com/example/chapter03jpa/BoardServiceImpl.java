package com.example.chapter03jpa;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    private BoardDAO boardDAO;

    @Override
    public void write() {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId("grape");
        boardEntity.setName("포도");
        boardEntity.setSubject("포도송송이");
        boardEntity.setContent("알알이 붙은 포도송이들");

        //DB로 넘겨주자
        boardDAO.save(boardEntity);
    }

    @Override
    public List<BoardEntity> list() {
        /*
        이방법이 편한거같은데
        List<BoardEntity> list = boardDAO.findAll(Sort.by("seq").descending());
        return list;
        */

        //쿼리메소드
        return boardDAO.findAllByOrderBySeqDesc();
    }
}
