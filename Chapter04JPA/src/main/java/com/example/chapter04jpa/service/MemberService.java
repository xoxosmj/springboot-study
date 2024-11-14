package com.example.chapter04jpa.service;

import com.example.chapter04jpa.dto.MemberDTO;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface MemberService {
    public String isExistId(String id);

    public void register(MemberDTO memberDTO);

    public Map<String, Object> getMemberList(Pageable pageable);
}
