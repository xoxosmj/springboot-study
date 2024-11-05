package thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import thymeleaf.bean.PersonDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {
    public ThymeleafController() {
        System.out.println("ThymeleafController 생성자");
    }

    @GetMapping(value = "hithymeleaf")
    public String hithymeleaf(Model model) {
        model.addAttribute("say", "안녕하세요");
        return "basic/hithymeleaf";
    }

    @GetMapping(value = "literal")
    public String literal(Model model) {
        model.addAttribute("data", "블라블라");
        return "basic/literal";
    }

    @GetMapping(value = "variable")
    public String variable(Model model) {
        PersonDTO aa = new PersonDTO("홍길동", 25);
        PersonDTO bb = new PersonDTO("김태리", 32);
        PersonDTO cc = new PersonDTO("이제훈", 40);
        model.addAttribute("aa", aa);

        List<PersonDTO> list = new ArrayList<>();
        list.add(aa);
        list.add(bb);
        list.add(cc);
        model.addAttribute("list", list);

        Map<String, Object> map = new HashMap<>();
        map.put("cc", cc);
        model.addAttribute("map", map);

        return "basic/variable";
    }

    @GetMapping(value = "operation")
    public String operation(Model model) {

        return "basic/operation";

    }
}

