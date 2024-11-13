package com.example.chapter03jpa;


import java.util.List;

public interface BoardService {
    void write();

    List<BoardEntity> list();
}
