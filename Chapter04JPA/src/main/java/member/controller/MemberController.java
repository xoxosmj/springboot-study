package member.controller;

import member.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "member")
public class MemberController {
    MemberService memberService;

    @GetMapping("registerForm")
    public String registerForm() {
        return "member/registerForm";
    }

    @GetMapping("listForm")
    public String listForm() {
        return "member/listForm";

    }

}
