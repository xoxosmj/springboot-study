package thymeleaf.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import thymeleaf.bean.PersonDTO;

import java.time.LocalDateTime;
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

    @GetMapping(value = "text_basic")
    public String text_basic(ModelMap modelMap) {
        modelMap.put("data", "머시기머시기");
        return "basic/text_basic";
    }

    @GetMapping(value = "attribute")
    public String attribute(Model model) {
        model.addAttribute("data", "머시기머시기");
        return "basic/attribute";
    }

    @GetMapping(value = "ifcondition")
    public String ifcondition(Model model) {
        model.addAttribute("age", 25);
        model.addAttribute("movie", "베놈");
        model.addAttribute("today", "수요일");
        return "basic/ifcondition";
    }

    @GetMapping(value = "condition")
    public String condition(Model model) {
        PersonDTO aa = new PersonDTO("홍길동", 25);
        PersonDTO bb = new PersonDTO("김태리", 17);
        PersonDTO cc = new PersonDTO("이제훈", 40);

        List<PersonDTO> list = new ArrayList<>();
        list.add(aa);
        list.add(bb);
        list.add(cc);

        model.addAttribute("list", list);
        return "basic/condition";
    }

    @GetMapping("each")
    public String each(Model model) {
        PersonDTO aa = new PersonDTO("홍길동", 25);
        PersonDTO bb = new PersonDTO("김태리", 17);
        PersonDTO cc = new PersonDTO("이제훈", 40);

        List<PersonDTO> list = new ArrayList<>();
        list.add(aa);
        list.add(bb);
        list.add(cc);

        model.addAttribute("list", list);
        return "basic/each";
    }

    @GetMapping("block")
    public String block(Model model) {
        PersonDTO aa = new PersonDTO("홍길동", 25);
        PersonDTO bb = new PersonDTO("김태리", 17);
        PersonDTO cc = new PersonDTO("이제훈", 40);

        List<PersonDTO> list = new ArrayList<>();
        list.add(aa);
        list.add(bb);
        list.add(cc);

        model.addAttribute("list", list);
        return "basic/block";
    }

    @GetMapping("link")
    public String link(Model model) {
        return "basic/link";
    }

    @GetMapping("hello")
    @ResponseBody
    public String hello(@RequestParam(value = "name", defaultValue = "noname") String name,
                        @RequestParam(value = "age", defaultValue = "69") int age) {
        return name + " / " + age;
    }

    @GetMapping(value = "hello/{name}/{age}")
    @ResponseBody
    public String hello2(@PathVariable("name") String name,
                         @PathVariable("age") int age) {
        return name + " / " + age;
    }

    @GetMapping(value = "hello/{name}")
    @ResponseBody
    public String hello3(@PathVariable("name") String name,
                         @RequestParam(value = "age",defaultValue = "53") int age) {
        return name + " / " + age;
    }


    @GetMapping("select")
    @ResponseBody
    public String select() {
        return "select 요청";
    }


    @GetMapping("insert")
    @ResponseBody
    public String insert(@RequestParam(name = "pageno",defaultValue = "10000") int pageno) {
        return "pageno = "+pageno;
    }

    @GetMapping("character/detail/{name}/{number}")
    @ResponseBody
    public String characterDetail(@PathVariable("name") String name, @PathVariable("number") int number) {
        return "name="+name+",number="+number;
    }

    @GetMapping("basicobjects")
    public String basicobjects(HttpSession session, Model model) {
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("now", now);
        model.addAttribute("str", "     스프링 부뜨   SpRinG bOOt    ");

        //세션
        session.setAttribute("memId","hong");
        session.setAttribute("memName","오효석");



        return "basic/basicobjects";
    }

    @GetMapping("helloTest")
    public String helloTest(@RequestParam String str) {
        return str;
    }


    @GetMapping("fragmentmain1")
    public String fragmentmain1() {
        return "basic/fragmentmain1";
    }

    @GetMapping("fragmentmain2")
    public String fragmentmain2() {
        return "basic/fragmentmain2";
    }



}

