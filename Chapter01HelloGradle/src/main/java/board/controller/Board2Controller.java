package board.controller;

import board.bean.BoardDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Board2Controller {
    private List<BoardDTO> list = new ArrayList<>();
}
