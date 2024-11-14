package com.example.chapter04jpa.service.impl;

import com.example.chapter04jpa.common.MemberPaging;
import com.example.chapter04jpa.dto.MemberDTO;
import com.example.chapter04jpa.entity.MemberEntity;
import com.example.chapter04jpa.repository.MemberRepository;
import com.example.chapter04jpa.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;
    private final MemberPaging memberPaging;

    public MemberServiceImpl(MemberRepository memberRepository, MemberPaging memberPaging) {
        this.memberRepository = memberRepository;
        this.memberPaging = memberPaging;
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
    public Map<String, Object> getMemberList(Pageable pageable) {
        Page<MemberEntity> list = memberRepository.findAll(pageable);

        int totalA = memberRepository.findAll().size();
        System.out.println("totalA=" + totalA);

        memberPaging.setCurrentPage(pageable.getPageNumber());
        memberPaging.setPageBlock(3);
        memberPaging.setPageSize(3);
        memberPaging.setTotalA(totalA);
        memberPaging.makePagingHTML();

        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        map.put("memberPaging",memberPaging);

        return map;

    }
}
