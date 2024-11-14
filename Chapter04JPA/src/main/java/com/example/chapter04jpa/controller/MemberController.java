package com.example.chapter04jpa.controller;

import com.example.chapter04jpa.dto.MemberDTO;
import com.example.chapter04jpa.entity.MemberEntity;
import com.example.chapter04jpa.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("list")
    public String list(Model model, @PageableDefault(page = 0, size = 3) Pageable pageable) {

        Page<MemberEntity> pagedList = memberService.getAllMembers(pageable);

        /*
        int pageGroupSize = 3;  // 한 번에 보여줄 페이지 버튼 개수
        int currentPage = pagedList.getNumber();  // 현재 페이지 번호 (0부터 시작)
        int totalPages = pagedList.getTotalPages();  // 전체 페이지 수

        int startPage = (currentPage / pageGroupSize) * pageGroupSize;  // 현재 그룹의 시작 페이지
        int endPage = Math.min(startPage + pageGroupSize, totalPages);  // 현재 그룹의 마지막 페이지

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        */

        model.addAttribute("pagedList", pagedList);

        return "member/list";
    }

    @GetMapping("search")
    public String search(@RequestParam String columnName, @RequestParam String columnValue, Model model,@PageableDefault(page = 0, size = 3) Pageable pageable) {
        Page<MemberEntity> pagedList = memberService.getSearchedMembers(columnName, columnValue, pageable);

        model.addAttribute("pagedList", pagedList);
        model.addAttribute("columnName", columnName);
        model.addAttribute("columnValue", columnValue);
        return "member/list";
    }

}
