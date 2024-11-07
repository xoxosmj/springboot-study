package user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import user.service.UserService;

@RequestMapping("user")
@Controller
public class UserController {

    private UserService userService;
    //생성자 인젝션, 오토와이어를 대신한다
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("writeForm")
    public String writeForm() {
        return "user/writeForm";
    }

    @PostMapping("getExistId")
    @ResponseBody
    public String getExistId(@RequestParam("id") String id) {
        return userService.getExistId(id);
    }
}


