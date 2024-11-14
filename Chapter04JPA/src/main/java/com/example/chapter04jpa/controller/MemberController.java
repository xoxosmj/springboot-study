package com.example.chapter04jpa.controller;

import com.example.chapter04jpa.dto.MemberDTO;
import com.example.chapter04jpa.entity.MemberEntity;
import com.example.chapter04jpa.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "member")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("registerForm")
    public String registerForm() {
        return "member/registerForm";
    }

    @PostMapping("isExistId")
    @ResponseBody
    public String isExistId(@RequestParam String id) {
        String isExist = memberService.isExistId(id);
        return isExist;
    }

    @PostMapping("register")
    @ResponseBody
    public void register(@ModelAttribute MemberDTO memberDTO) {
        System.out.println(memberDTO);
        memberService.register(memberDTO);
    }

    //페이징 처리 복습필요
    @GetMapping("list")
    public String list(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                       //pg는 0부터 시작, 0이면 1페이지, 1이면 2페이지,...
                       @PageableDefault(page = 0, size = 3, sort = "name", direction = Sort.Direction.DESC) Pageable pageable,
                       Model model) {
        Map<String, Object> map = memberService.getMemberList(pageable);

        model.addAttribute("map", map);
        return "member/list";
    }
}
