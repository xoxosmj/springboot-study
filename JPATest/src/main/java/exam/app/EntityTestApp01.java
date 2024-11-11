package exam.app;

import exam.entity.EntityTest01;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class EntityTestApp01 {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        System.out.println("EntityManagerFactory created");
        EntityTest01 entityTest01;

        em.getTransaction().begin();

        //@GeneratedValue(strategy = GenerationType.IDENTITY) << 설정하기전 코드

       /* entityTest01 = new EntityTest01();
        entityTest01.setId(10);
        entityTest01.setName("홍홍동");
        entityTest01.setAge(25);
        entityTest01.setBirthday(LocalDateTime.now());
        em.persist(entityTest01); // 객체 주입
        em.getTransaction().commit(); // 실행
        em.close();
        factory.close();*/

        //@GeneratedValue(strategy = GenerationType.IDENTITY) << 설정한 후 코드

        for (int i = 1; i <= 5; i++) {
            entityTest01 = new EntityTest01();
            entityTest01.setName("홍길동" + i);
            entityTest01.setAge((int) (Math.random() * 26) + 25);
            entityTest01.setBirthday(LocalDateTime.now());
            em.persist(entityTest01); // 객체 주입

        }
        em.getTransaction().commit(); // 실행
        em.close();
        factory.close();

    }
}
