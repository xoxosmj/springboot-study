package com.example.chapter03jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BoardDAO extends JpaRepository<BoardEntity, Integer> {

    public BoardEntity findBySeq(int seq);

    List<BoardEntity> findByLogtimeNull();

    List<BoardEntity> findByIdContaining(String o);


    List<BoardEntity> findByLogtimeAfter(LocalDateTime of);

    List<BoardEntity> findBySeqBetween(int i, int i1);
}
