package exam.app;

import exam.entity.EntityTest01;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EntityTestApp02 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();

        TypedQuery<EntityTest01> tq = em.createQuery("select t from EntityTest01 t", EntityTest01.class); // 흠;;
        List<EntityTest01> list = tq.getResultList();

//        for (EntityTest01 et : list) {
//            System.out.println(et);
//        }
        list.stream().forEach(e -> System.out.println(e));

        em.close();
        factory.close();
    }
}
