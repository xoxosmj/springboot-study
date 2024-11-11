package exam.app;

import exam.entity.EntityTest01;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDateTime;
import java.util.List;

public class EntityTestApp04 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();

            // 데이터 삽입
            for (int i = 1; i <= 5; i++) {
                EntityTest01 entityTest01 = new EntityTest01();
                entityTest01.setName("또치" + i);
                entityTest01.setAge((int) (Math.random() * 26) + 25);
                entityTest01.setBirthday(LocalDateTime.now());
                em.persist(entityTest01); // 엔티티 저장
            }

            // 트랜잭션 커밋
            em.getTransaction().commit();

            // 데이터 조회 및 출력
            TypedQuery<EntityTest01> tq = em.createQuery("select t from EntityTest01 t", EntityTest01.class);
            List<EntityTest01> list = tq.getResultList();
            list.forEach(System.out::println);

            System.out.println("------------------------------------------------");

            // 데이터 조회 및 출력 (다시 조회)
            tq = em.createQuery("select t from EntityTest01 t", EntityTest01.class);
            list = tq.getResultList();
            list.forEach(System.out::println);

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // 예외 발생 시 롤백
            }
            e.printStackTrace();
        } finally {
            em.close(); // EntityManager 닫기
            factory.close(); // EntityManagerFactory 닫기
        }
    }
}
