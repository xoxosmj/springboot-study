package user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import user.bean.UserDTO;
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


    @PostMapping("write")
    @ResponseBody
    public void write(@ModelAttribute UserDTO userDTO) {
        userService.write(userDTO);

    }

    @PostMapping("write2")
    //리스폰스 바디가 없다 이유??
    public String write2(@ModelAttribute UserDTO userDTO) {
        System.out.println(userDTO);
        userService.write(userDTO);
        return "user/write";

    }

    @GetMapping("list")
    public String list() {
        System.out.println("list");

        return null;
    }
}


