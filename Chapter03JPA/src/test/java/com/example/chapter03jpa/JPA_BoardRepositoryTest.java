package com.example.chapter03jpa;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

//@DataJpaTest를 사용하면 자동으로 EmbededDatabase-H2를 사용하게 된다.
//MySQL과 같이 외부의 DB를 연결하려는 경우엔 이 어노테이션을 설정한다.
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //먼뜻이고
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 내장 DB가 H2를 수행하지 않겠다
public class JPA_BoardRepositoryTest {

    @Autowired
    private BoardDAO boardDAO;

    @BeforeEach
    public void solid() {
        System.out.println();
        System.out.println("-".repeat(80));
    }

    @AfterEach
    public void solid2() {
        System.out.println();
        System.out.println();
    }

    @Test
    public void list1(){
        List<BoardEntity> list = boardDAO.findAll();
        list.stream().forEach(System.out::println); // 설명필요 안외워짐

    }

    @Test
    public void list2(){
        List<BoardEntity> list = boardDAO.findAll(Sort.by("name").ascending()); //정렬추가
        list.stream().forEach(System.out::println);

    }

    @Test
    public void list3(){
        List<BoardEntity> list = boardDAO.findAll(Sort.by("name").descending()); //정렬추가
        list.stream().forEach(System.out::println);

    }

    @Test
    public void list4(){
        Page<BoardEntity> list = boardDAO.findAll(PageRequest.of(0,3));
        list.stream().forEach(System.out::println);

    }

    @Test
    public void list5(){
        Page<BoardEntity> list = boardDAO.findAll( PageRequest.of(1,3));
        list.stream().forEach(System.out::println);

    }

    @Test
    public void list6(){
        Page<BoardEntity> list = boardDAO.findAll(PageRequest.of(0,3, Sort.by("name")));
        list.stream().forEach(System.out::println);

    }

}
