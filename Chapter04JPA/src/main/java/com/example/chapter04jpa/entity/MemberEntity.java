package com.example.chapter04jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "membertbl")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Column(name="id", length = 30, unique = true, nullable = false)
    private String id;

   @Column(name="pwd",  length = 300, nullable = false)
    private String pwd;

    @Column(name="name", length = 30, nullable = false)
    private String name;

}

