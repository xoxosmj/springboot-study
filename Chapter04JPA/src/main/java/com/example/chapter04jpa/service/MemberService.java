package com.example.chapter04jpa.service;

import com.example.chapter04jpa.dto.MemberDTO;
import com.example.chapter04jpa.entity.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {
    public String isExistId(String id);

    public void register(MemberDTO memberDTO);

    Page<MemberEntity> getAllMembers(Pageable pageable);

    Page<MemberEntity> getSearchedMembers(String columnName, String columnValue, Pageable pageable);
}
