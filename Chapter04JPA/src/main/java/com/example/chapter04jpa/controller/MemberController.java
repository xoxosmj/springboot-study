package com.example.chapter04jpa.controller;

import com.example.chapter04jpa.dto.MemberDTO;
import com.example.chapter04jpa.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("listForm")
    public String listForm() {
        return "member/listForm";

    }

    @GetMapping("list")
    @ResponseBody
    public String list() {
        return "com/example/chapter04jpa/member/list";
    }
}
