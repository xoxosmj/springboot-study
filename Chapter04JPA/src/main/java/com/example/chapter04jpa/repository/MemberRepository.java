package com.example.chapter04jpa.repository;

import com.example.chapter04jpa.entity.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

    List<MemberEntity> findById(String id);

    Page<MemberEntity> findAllByIdContaining(String columnValue, Pageable pageable);

    Page<MemberEntity> findAllByNameContaining(String columnValue, Pageable pageable);
}
