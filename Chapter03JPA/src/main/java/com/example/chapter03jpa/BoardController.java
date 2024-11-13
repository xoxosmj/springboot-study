package com.example.chapter03jpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    private BoardService boardService;

    @GetMapping("/board/write")
    public String write() {
        boardService.write();
        return "write success";
    }

    @GetMapping("/board/list")
    public List<BoardEntity> list() {
        return boardService.list(); //RestController니까 json형식으로 브라우저에 뿌린다.
    }
}
