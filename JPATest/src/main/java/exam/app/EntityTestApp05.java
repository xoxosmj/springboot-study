package exam.app;

import exam.entity.EntityTest01;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EntityTestApp05 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        System.out.println("엔티티 삭제");
        EntityTest01 entityTest01 = em.find(EntityTest01.class,1);
        em.remove(entityTest01);

        TypedQuery<EntityTest01> tq = em.createQuery("select t from EntityTest01 t", EntityTest01.class);
        List<EntityTest01> list = tq.getResultList();
        list.forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
        factory.close();

    }
}
