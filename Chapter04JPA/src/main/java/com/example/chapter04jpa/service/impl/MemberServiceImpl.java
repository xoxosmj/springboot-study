package com.example.chapter04jpa.service.impl;

import com.example.chapter04jpa.dto.MemberDTO;
import com.example.chapter04jpa.entity.MemberEntity;
import com.example.chapter04jpa.repository.MemberRepository;
import com.example.chapter04jpa.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


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

    @Override
    public Page<MemberEntity> getAllMembers(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    @Override
    public Page<MemberEntity> getSearchedMembers(String columnName, String columnValue, Pageable pageable) {
        if (columnName.equals("id")) {
            return memberRepository.findAllByIdContaining(columnValue, pageable);
        } else {
            return memberRepository.findAllByNameContaining(columnValue, pageable);
        }
    }
}

