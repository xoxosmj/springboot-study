package com.example.chapter04jpa.service;

import com.example.chapter04jpa.dto.MemberDTO;

public interface MemberService {
    public String isExistId(String id);

    public void register(MemberDTO memberDTO);
}
