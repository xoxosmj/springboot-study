package exam.app;

import exam.entity.EntityTest01;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class EntityTestApp01 {

    public void run() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        System.out.println("EntityManagerFactory created");
        EntityTest01 entityTest01;

        em.getTransaction().begin();

        entityTest01 = new EntityTest01();
        entityTest01.setId(10);
        entityTest01.setName("홍홍동");
        entityTest01.setAge(25);
        entityTest01.setBirthday(LocalDateTime.now());

        em.persist(entityTest01); // 객체 주입
        em.getTransaction().commit(); // 실행
        em.close();
        factory.close();
    }
}
