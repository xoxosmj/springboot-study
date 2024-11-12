package exam.app;

import exam.entity.Emp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class HelloJPA02 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();

        Query query  = em.createQuery("SELECT emp from Emp emp", Emp.class); //JPQL, Emp는 엔티티 클래스
        List<Emp> list = query.getResultList();

        for (Emp emp : list) {
            System.out.println(emp.getEname());
        }
    }
}
