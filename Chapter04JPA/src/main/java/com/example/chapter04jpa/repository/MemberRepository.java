package com.example.chapter04jpa.repository;


import com.example.chapter04jpa.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Integer> {

    public List<MemberEntity> findById(String id);
}
