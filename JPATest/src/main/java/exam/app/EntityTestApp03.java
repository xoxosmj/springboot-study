package exam.app;

import exam.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EntityTestApp03 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        /*
        Person entity1 = new Person();
        entity1.setAge(25);
        entity1.setName("홍길동");
        em.persist(entity1);

        Person entity2 = new Person();
        entity2.setAge(40);
        entity2.setName("이제훈");
        em.persist(entity2);

        Person entity3 = new Person();
        entity3.setAge(32);
        entity3.setName("김태리");
        em.persist(entity3);
        */

        Person person01 = new Person("홍길동",25);
        Person person02 = new Person("이제훈",40);
        Person person03 = new Person("김태리",32);

        //영속성 컨텍스트
        em.persist(person01);
        em.persist(person02);
        em.persist(person03);

        em.getTransaction().commit();

        TypedQuery<Person> query = em.createQuery("select p from Person p", Person.class);
        List<Person> list = query.getResultList();

        list.stream().forEach(e -> System.out.println(e)); // forEach 첫번째 방법
        list.stream().forEach(System.out::println); // forEach 두번째 방법

        System.out.println("블라블라 이거도깨지나");

        em.close();
        factory.close();

    }
}

//[문제1]
// person 테이블의 엔티티 객체를 생성하고 다음 3개의 데이터 입력 후 모두 조회하시오
// 테이블 : person
// 컬럼: name, age
// 데이터: 홍길동,25
//        이제훈, 40
//        김태리 , 32