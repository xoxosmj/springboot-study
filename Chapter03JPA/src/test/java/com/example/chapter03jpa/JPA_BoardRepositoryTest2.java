package com.example.chapter03jpa;


import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

//@DataJpaTest를 사용하면 자동으로 EmbededDatabase-H2를 사용하게 된다.
//MySQL과 같이 외부의 DB를 연결하려는 경우엔 이 어노테이션을 설정한다.
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //먼뜻이고
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 내장 DB가 H2를 수행하지 않겠다
public class JPA_BoardRepositoryTest2 {


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
    @Order(1) //실행순서를 정한다. 숫자가 작을수록 먼저 실행한다.
    @Rollback(false) //테스트 이기 때문에 기본이 롤백이다. false로 햇으므로 db에 실제로 값이 들어감.
    public void insert(){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId("banana");
        boardEntity.setName("바나나");
        boardEntity.setSubject("예전에는 바나나가 정말 비쌋다");
        boardEntity.setContent("그래서 안먹을꺼야? 응");

        boardDAO.save(boardEntity); //레코드가 없으면 수정(insert), 있으면 수정(update) 수행한다.
    }



    @Test
    @Order(2) //실행순서를 정한다. 숫자가 작을수록 먼저 실행한다.
    @Rollback(false) //테스트 이기 때문에 기본이 롤백이다. false로 햇으므로 db에 실제로 값이 들어감.
    public void insert2(){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId("strawberry");
        boardEntity.setName("딸기");
        boardEntity.setSubject("딸기를 야하게 말해봐");
        boardEntity.setContent("딸딸기");

        boardDAO.save(boardEntity);
    }

    @Test
    @Order(3)
    public void list(){
        List<BoardEntity> list = boardDAO.findAll();
        list.stream().forEach(System.out::println);
    }


}
