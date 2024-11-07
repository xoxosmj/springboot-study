package user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@Controller
public class UserController {

    @GetMapping("writeForm")
    public String writeForm() {
        return "user/writeForm";
    }
}
