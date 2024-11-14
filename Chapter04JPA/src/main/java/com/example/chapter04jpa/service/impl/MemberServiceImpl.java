package com.example.chapter04jpa.service.impl;

import com.example.chapter04jpa.dto.MemberDTO;
import com.example.chapter04jpa.entity.MemberEntity;
import com.example.chapter04jpa.repository.MemberRepository;
import com.example.chapter04jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private MemberRepository memberRepository;

    @Override
    public String isExistId(String id) {

        List<MemberEntity> list = memberRepository.findById(id);
        if (list.isEmpty()) {
            return "non_exist";
        } else {
            return "exist";
        }
    }

    @Override
    public void register(MemberDTO memberDTO) {
        memberRepository.save(memberDTO.toEntity());
    }
}
