package com.example.chapter03jpa;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="boardtbl")
@Data
public class BoardEntity {

    @Id
    @Column(name="seq")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int seq;

    @Column(name="id", nullable= false,length = 30)
    private String id;


    @Column(name="name", nullable= false,length = 30)
    private String name;


    @Column(name="subject")
    private String subject;


    @Column(name="content")
    private String content;

    @UpdateTimestamp // update 할때 자동으로 시간 등록
    private LocalDateTime logtime = LocalDateTime.now();

}
